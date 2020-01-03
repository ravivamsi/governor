/**
 * 
 */
package com.cgovern.governor.commons;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author vamsiravi
 *
 */
public class Crypt {
	
	public static String encodeCreds(String username, String password) {
		
		String encodedPassword = password; 
		
		for(Integer i=0; i<username.length(); i++) {
			encodedPassword = Base64.getEncoder().encodeToString(encodedPassword.getBytes());
		}
		
		return encodedPassword;
		
	}
	
	public static String decodeCreds(String username, String encodedPassword) {
		String decodedPassword = encodedPassword;
		
		
		for(Integer i=0; i< username.length(); i++) {
			decodedPassword = new String(Base64.getDecoder().decode(decodedPassword));
		}
		
		
		return decodedPassword;
	}
	
	public static String urlEncode(String value) {
		
		try {
			return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
		}catch(UnsupportedEncodingException ex) {
			throw new RuntimeException(ex.getCause());
		}
		
		
	}
	
	public static String urlDecode(String encodedvalue) {
		
		try {
			return URLDecoder.decode(encodedvalue, StandardCharsets.UTF_8.toString());
		}catch(UnsupportedEncodingException exception){
			throw new RuntimeException(exception.getCause());
		}
	}

}
