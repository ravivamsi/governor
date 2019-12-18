/**
 * 
 */
package com.servec.governor.commons;

import static org.apache.commons.io.FilenameUtils.getFullPath;
import static org.apache.commons.io.FilenameUtils.getName;
import static org.apache.commons.lang3.StringUtils.trim;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintWriter;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vamsiravi
 *
 */


import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Executer {
	
	private static final Logger LOG = LoggerFactory.getLogger(Executer.class);
    private static final String SSH = "ssh";
    private static final String FILE = "file";

	public void onWorkerSingleCommand(String hostname, String username, String password, String command) throws JSchException, IOException {
		
		
		java.util.Properties config = new java.util.Properties(); 
    	config.put("StrictHostKeyChecking", "no");
    	JSch jsch = new JSch();
    	Session session=jsch.getSession(username, hostname, 22);
    	session.setPassword(password);
    	session.setConfig(config);
    	session.connect();
    	
    	
    	Channel channel=session.openChannel("exec");
        ((ChannelExec)channel).setCommand(command);
        channel.setInputStream(null);
        ((ChannelExec)channel).setErrStream(System.err);
    	
        
        InputStream in=channel.getInputStream();
        channel.connect();
        byte[] tmp=new byte[1024];
        while(true){
          while(in.available()>0){
            int i=in.read(tmp, 0, 1024);
            if(i<0)break;
            System.out.print(new String(tmp, 0, i));
          }
          if(channel.isClosed()){
            System.out.println("exit-status: "+channel.getExitStatus());
            break;
          }
          try{Thread.sleep(1000);}catch(Exception ee){}
        }
        channel.disconnect();
        session.disconnect();
    	
	}
	
	/**
     * <pre>
     * <code>
     * sftp("file:/C:/home/file.txt", "ssh://user:pass@host/home");
     * sftp("ssh://user:pass@host/home/file.txt", "file:/C:/home");
     * </code>
     *
     * <pre>
     *
     * @param fromUri
     *            file
     * @param toUri
     *            directory
     */
    public static void sftp(String fromUri, String toUri) {
        URI from = URI.create(fromUri);
        URI to = URI.create(toUri);

        if (SSH.equals(to.getScheme()) && FILE.equals(from.getScheme()))
            upload(from, to);
        else if (SSH.equals(from.getScheme()) && FILE.equals(to.getScheme()))
            download(from, to);
        else
            throw new IllegalArgumentException();
    }

    private static void upload(URI from, URI to) {
        try (SessionHolder<ChannelSftp> session = new SessionHolder<>("sftp", to);
                FileInputStream fis = new FileInputStream(new File(from))) {

            LOG.info("Uploading {} --> {}", from, session.getMaskedUri());
            ChannelSftp channel = session.getChannel();
            channel.connect();
            channel.cd(to.getPath());
            channel.put(fis, getName(from.getPath()));

        } catch (Exception e) {
            throw new RuntimeException("Cannot upload file", e);
        }
    }

    private static void download(URI from, URI to) {
        File out = new File(new File(to), getName(from.getPath()));
        try (SessionHolder<ChannelSftp> session = new SessionHolder<>("sftp", from);
                OutputStream os = new FileOutputStream(out);
                BufferedOutputStream bos = new BufferedOutputStream(os)) {

            LOG.info("Downloading {} --> {}", session.getMaskedUri(), to);
            ChannelSftp channel = session.getChannel();
            channel.connect();
            channel.cd(getFullPath(from.getPath()));
            channel.get(getName(from.getPath()), bos);

        } catch (Exception e) {
            throw new RuntimeException("Cannot download file", e);
        }
    }

    /**
     * <pre>
     * <code>
     * shell("ssh://user:pass@host", System.in, System.out);
     * </code>
     * </pre>
     */
    public static void shell(String connectUri, InputStream is, OutputStream os) {
        try (SessionHolder<ChannelShell> session = new SessionHolder<>("shell", URI.create(connectUri))) {
            shell(session, is, os);
        }
    }

    /**
     * <pre>
     * <code>
     * String remoteOutput = shell("ssh://user:pass@host/work/dir/path", "ls")
     * </code>
     * </pre>
     */
    public static String shell(String connectUri, String command) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            shell(connectUri, command, baos);
            return baos.toString();
        } catch (RuntimeException e) {
            LOG.warn(baos.toString());
            throw e;
        }
    }

    /**
     * <pre>
     * <code>
     * shell("ssh://user:pass@host/work/dir/path", "ls", System.out)
     * </code>
     * </pre>
     */
    public static void shell(String connectUri, String script, OutputStream out) {
        try (SessionHolder<ChannelShell> session = new SessionHolder<>("shell", URI.create(connectUri));
                PipedOutputStream pipe = new PipedOutputStream();
                PipedInputStream in = new PipedInputStream(pipe);
                PrintWriter pw = new PrintWriter(pipe)) {

            if (session.getWorkDir() != null)
                pw.println("cd " + session.getWorkDir());
            pw.println(script);
            pw.println("exit");
            pw.flush();

            shell(session, in, out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void shell(SessionHolder<ChannelShell> session, InputStream is, OutputStream os) {
        try {
            ChannelShell channel = session.getChannel();
            channel.setInputStream(is, true);
            channel.setOutputStream(os, true);

            LOG.info("Starting shell for " + session.getMaskedUri());
            session.execute();
            session.assertExitStatus("Check shell output for error details.");
        } catch (InterruptedException | JSchException e) {
            throw new RuntimeException("Cannot execute script", e);
        }
    }

    /**
     * <pre>
     * <code>
     * System.out.println(exec("ssh://user:pass@host/work/dir/path", "ls -t | head -n1"));
     * </code>
     * 
     * <pre>
     * 
     * @param connectUri
     * @param command
     * @return
     */
    public static String exec(String connectUri, String command) {
        try (SessionHolder<ChannelExec> session = new SessionHolder<>("exec", URI.create(connectUri))) {
            String scriptToExecute = session.getWorkDir() == null
                    ? command
                    : "cd " + session.getWorkDir() + "\n" + command;
            return exec(session, scriptToExecute);
        }
    }

    private static String exec(SessionHolder<ChannelExec> session, String command) {
        try (PipedOutputStream errPipe = new PipedOutputStream();
                PipedInputStream errIs = new PipedInputStream(errPipe);
                InputStream is = session.getChannel().getInputStream()) {

            ChannelExec channel = session.getChannel();
            channel.setInputStream(null);
            channel.setErrStream(errPipe);
            channel.setCommand(command);

            LOG.info("Starting exec for " + session.getMaskedUri());
            session.execute();
            String output = IOUtils.toString(is);
            session.assertExitStatus(IOUtils.toString(errIs));

            return trim(output);
        } catch (InterruptedException | JSchException | IOException e) {
            throw new RuntimeException("Cannot execute command", e);
        }
    }
	
	
}
