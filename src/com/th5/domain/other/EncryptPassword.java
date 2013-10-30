package com.th5.domain.other;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptPassword {

	/**Encrypts a password to sha512hex
	 * @param password
	 * @return the encrypted password
	 */
	public static String encryptPassword (String password) {
		return DigestUtils.sha512Hex( password );
	}
}
