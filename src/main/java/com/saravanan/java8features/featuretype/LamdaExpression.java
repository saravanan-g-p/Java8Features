package com.saravanan.java8features.featuretype;

import java.util.Arrays;
import java.util.List;

import com.saravanan.java8features.functionalinterface.MultiplyTwoNumber;

public class LamdaExpression {

	public void multiplyValue() {

		MultiplyTwoNumber multiplyTwoNumber = (i, j) -> {
			return i * j;
		};

		System.out.println("Multiply Two Values - " + multiplyTwoNumber.multiplyvalue(5, 2));

	}

	public void iterator() {

		List<String> lstJavaTopic = Arrays.asList("Java", "Spring", "SpringBoot", "MicroService", "Apache Kafka",
				"RabbitMq");

		lstJavaTopic.forEach(t -> System.out.println("Call Iterator " + t));

	}
}
