package com.saravanan.java8features.featuretype;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {

	public void methodReference() {

		System.out.println("----------------------------Static Method Reference ---------------------------");
		BinaryOperator<Double> multiply = MethodReference::multiplication;
		System.out.println("Multiplication - " + multiply.apply(10.0, 5.0));

		Function<Double, Double> squre = Math::sqrt;
		System.out.println("Square root  - " + squre.apply(4.0));

		List<Integer> listNumber = Arrays.asList(5, 9, 4, 8, 7, 6, 2, 4);
		listNumber.forEach(MethodReference::getNumber);

		System.out.println();
		System.out.println("------------------------------Object Method Reference ---------------------------");
		MethodReference methodReference = new MethodReference();
		BiFunction<Double, Double, Double> addition = methodReference::addition;
		System.out.println("Addtion - " + addition.apply(150.0, 985.0));

		System.out.println("------------------------ Constructor Method Reference ----------------------------");
		Supplier<MethodReference> supplier = MethodReference::new;
		MethodReference methodReference2 = supplier.get();

		List<String> lstCource = Arrays.asList("Spring", "SpringBoot", "SpringSecurity", "MicroService");
		lstCource.forEach(MethodReference::new);

	}
}
