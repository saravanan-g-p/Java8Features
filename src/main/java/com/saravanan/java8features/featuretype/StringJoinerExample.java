package com.saravanan.java8features.featuretype;

import java.util.StringJoiner;

public class StringJoinerExample {

	public void stringJoiner() {

		StringJoiner stringJoiner = new StringJoiner(" / ");
		stringJoiner.add("Spring");
		stringJoiner.add("SpringBoot");
		stringJoiner.add("SpringSecurity");

		System.out.println("StringJoiner - " + stringJoiner);

		StringJoiner stringJoinerWithPrefix_Suffix = new StringJoiner(" | ", "[ ", " ]");
		stringJoinerWithPrefix_Suffix.add("MicroServices");
		stringJoinerWithPrefix_Suffix.add("Kafka");
		stringJoinerWithPrefix_Suffix.add("RabbitMQ");

		System.out.println("String Joiner Prefix And Suffix - " + stringJoinerWithPrefix_Suffix);

		System.out.println("String Joiner Merge - " + stringJoinerWithPrefix_Suffix.merge(stringJoiner));
	}

}
