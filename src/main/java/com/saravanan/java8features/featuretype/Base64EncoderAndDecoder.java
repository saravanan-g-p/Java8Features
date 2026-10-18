package com.saravanan.java8features.featuretype;

import java.util.Base64;

public class Base64EncoderAndDecoder {

	public String encryptMessage(String message) {

		String encryptMessage = new String(Base64.getEncoder().encode(message.getBytes()));
		System.out.println("Actual Value - " + message);
		System.out.println("Encrypt Value - " + encryptMessage);

		return Base64.getEncoder().encodeToString(message.getBytes());
	}

	public void decryptMessage(String encryptMessage) {

		String decryptMessage = new String(Base64.getDecoder().decode(encryptMessage.getBytes()));
		System.out.println("Encrypt Message - " + encryptMessage);
		System.out.println("Decrypt Message - " + decryptMessage);
	}

}
