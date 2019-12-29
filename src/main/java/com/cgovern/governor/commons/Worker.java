/**
 * 
 */
package com.cgovern.governor.commons;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author vamsiravi
 *
 */
public class Worker {

	public static Boolean sendPingRequest(String ipAddress) throws UnknownHostException, IOException {
		InetAddress geek = InetAddress.getByName(ipAddress);
		System.out.println("Sending Ping Request to " + ipAddress);
		if (geek.isReachable(5000))
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	}

	public static Boolean remoteConnectTest(String ipAddress, String username, String password) {
//		TODO

		Boolean condition = Boolean.TRUE;

		if (condition) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

}
