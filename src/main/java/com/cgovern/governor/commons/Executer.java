/**
 * 
 */
package com.cgovern.governor.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vamsiravi
 *
 */

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class Executer {

	private static final Logger LOG = LoggerFactory.getLogger(Executer.class);

	public static void getWorkerHeartBeat(String hostname, String username, String password) throws JSchException {

		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		JSch jsch = new JSch();
		Session session = jsch.getSession(username, hostname, 22);
		session.setPassword(password);
		session.setConfig(config);
		session.connect();

		session.disconnect();
	}

	public static void onWorkerSingleCommand(String hostname, String username, String password, String command)
			throws JSchException, IOException {

		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		JSch jsch = new JSch();
		Session session = jsch.getSession(username, hostname, 22);
		session.setPassword(password);
		session.setConfig(config);
		session.connect();

		Channel channel = session.openChannel("exec");
		((ChannelExec) channel).setCommand(command);
		channel.setInputStream(null);
		((ChannelExec) channel).setErrStream(System.err);

		InputStream in = channel.getInputStream();
		channel.connect();
		byte[] tmp = new byte[1024];
		while (true) {
			while (in.available() > 0) {
				int i = in.read(tmp, 0, 1024);
				if (i < 0)
					break;
				System.out.print(new String(tmp, 0, i));
				LOG.info(new String(tmp, 0, i));
			}
			if (channel.isClosed()) {
				System.out.println("exit-status: " + channel.getExitStatus());
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception ee) {
			}
		}
		channel.disconnect();
		session.disconnect();

	}

	public static void onWorkerMultipleCommands(String hostname, String username, String password,
			List<String> commands) throws JSchException, IOException {

		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		JSch jsch = new JSch();
		Session session = jsch.getSession(username, hostname, 22);
		session.setPassword(password);
		session.setConfig(config);
		session.connect();

		for (String command : commands) {
			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
					LOG.info(new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
			channel.disconnect();
		}

		session.disconnect();

	}

	public static void uploadFromGovernor(String hostname, String username, String password, String localfilepath,
			String remoteDirectory, String filenameOnRemote) throws JSchException, SftpException {
//		TODO
		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		JSch jsch = new JSch();
//	    jsch.setKnownHosts("/Users/john/.ssh/known_hosts");
		Session jschSession = jsch.getSession(username, hostname);
		jschSession.setPassword(password);
		jschSession.setConfig(config);
		jschSession.connect();

		ChannelSftp channelSftp = (ChannelSftp) jschSession.openChannel("sftp");
		channelSftp.connect();

		channelSftp.put(localfilepath, remoteDirectory + filenameOnRemote);

		channelSftp.exit();
	}

	public static void downloadToGovernor(String hostname, String username, String password, String remotefilepath,
			String localDirectory, String filenameOnLocal) throws JSchException, SftpException {
//		TODO

		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		JSch jsch = new JSch();
//	    jsch.setKnownHosts("/Users/john/.ssh/known_hosts");
		Session jschSession = jsch.getSession(username, hostname);
		jschSession.setPassword(password);
		jschSession.setConfig(config);
		jschSession.connect();

		ChannelSftp channelSftp = (ChannelSftp) jschSession.openChannel("sftp");
		channelSftp.connect();

		channelSftp.get(remotefilepath, localDirectory + filenameOnLocal);

		channelSftp.exit();
	}

}
