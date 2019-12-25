/**
 * 
 */
package com.cgovern.governor.commons;

import static com.google.common.base.Preconditions.checkState;
import static java.lang.Thread.sleep;

import java.io.Closeable;
import java.net.URI;
import java.util.Map;
import java.util.Properties;

import com.cgovern.governor.models.RemoteUser;
import com.google.common.collect.ImmutableMap;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * @author vamsiravi
 *
 */
public class SessionHolder<C extends Channel> implements Closeable {

	private static final int DEFAULT_CONNECT_TIMEOUT = 5000;
	private static final int DEFAULT_PORT = 22;
	private static final int TERMINAL_HEIGHT = 1000;
	private static final int TERMINAL_WIDTH = 1000;
	private static final int TERMINAL_WIDTH_IN_PIXELS = 1000;
	private static final int TERMINAL_HEIGHT_IN_PIXELS = 1000;
	private static final int DEFAULT_WAIT_TIMEOUT = 100;

	private String channelType;
	private URI uri;
	private Session session;
	private C channel;

	public SessionHolder(String channelType, URI uri) {
		this(channelType, uri, ImmutableMap.of("StrictHostKeyChecking", "no"));
	}

	public SessionHolder(String channelType, URI uri, Map<String, String> props) {
		this.channelType = channelType;
		this.uri = uri;
		this.session = newSession(props);
		this.channel = newChannel(session);
	}

	private Session newSession(Map<String, String> props) {
		try {
			Properties config = new Properties();
			config.putAll(props);

			JSch jsch = new JSch();
			Session newSession = jsch.getSession(getUser(), uri.getHost(), getPort());
			newSession.setPassword(getPass());
			newSession.setUserInfo(new RemoteUser(getUser(), getPass()));
			newSession.setDaemonThread(true);
			newSession.setConfig(config);
			newSession.connect(DEFAULT_CONNECT_TIMEOUT);
			return newSession;
		} catch (JSchException e) {
			throw new RuntimeException("Cannot create session for " + getMaskedUri(), e);
		}
	}

	@SuppressWarnings("unchecked")
	private C newChannel(Session session) {
		try {
			Channel newChannel = session.openChannel(channelType);
			if (newChannel instanceof ChannelShell) {
				ChannelShell channelShell = (ChannelShell) newChannel;
				channelShell.setPtyType("ANSI", TERMINAL_WIDTH, TERMINAL_HEIGHT, TERMINAL_WIDTH_IN_PIXELS,
						TERMINAL_HEIGHT_IN_PIXELS);
			}
			return (C) newChannel;
		} catch (JSchException e) {
			throw new RuntimeException("Cannot create " + channelType + " channel for " + getMaskedUri(), e);
		}
	}

	public void assertExitStatus(String failMessage) {
		checkState(channel.getExitStatus() == 0, "Exit status %s for %s\n%s", channel.getExitStatus(), getMaskedUri(),
				failMessage);
	}

	public void execute() throws JSchException, InterruptedException {
		channel.connect();
		channel.start();
		while (!channel.isEOF())
			sleep(DEFAULT_WAIT_TIMEOUT);
	}

	public Session getSession() {
		return session;
	}

	public C getChannel() {
		return channel;
	}

	@Override
	public void close() {
		if (channel != null)
			channel.disconnect();
		if (session != null)
			session.disconnect();
	}

	public String getMaskedUri() {
		return uri.toString().replaceFirst(":[^:]*?@", "@");
	}

	public int getPort() {
		return uri.getPort() < 0 ? DEFAULT_PORT : uri.getPort();
	}

	public String getUser() {
		return uri.getUserInfo().split(":")[0];
	}

	public String getPass() {
		return uri.getUserInfo().split(":")[1];
	}

	public String getWorkDir() {
		return uri.getPath();
	}
}
