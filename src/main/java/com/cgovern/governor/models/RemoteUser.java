/**
 * 
 */
package com.cgovern.governor.models;

import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

/**
 * @author vamsiravi
 *
 */
public class RemoteUser implements UserInfo, UIKeyboardInteractive {

	private String user;
	private String pass;

	public RemoteUser(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	@Override
	public String getPassword() {
		return pass;
	}

	@Override
	public boolean promptYesNo(String str) {
		return false;
	}

	@Override
	public String getPassphrase() {
		return user;
	}

	@Override
	public boolean promptPassphrase(String message) {
		return true;
	}

	@Override
	public boolean promptPassword(String message) {
		return true;
	}

	@Override
	public void showMessage(String message) {
		// do nothing
	}

	@Override
	public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt,
			boolean[] echo) {
		return null;
	}
}
