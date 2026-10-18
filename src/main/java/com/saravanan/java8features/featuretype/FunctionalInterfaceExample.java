package com.saravanan.java8features.featuretype;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceExample {

	public void consumer() {

		Consumer<String> consumer = t -> {
			System.out.println("Consumer - " + t);
		};

		consumer.accept("Hello, World");
	}

	public void supplier() {

		Supplier<Double> supplier = () -> {

			return 5.0 * 2.0;
		};

		System.out.println("Supplier - " + supplier.get());
	}

	public void predicate() {

		Predicate<Double> isEvenNumber = t -> {
			return t % 2 == 0;
		};

		System.out.println("Predicate - Numbber Even [" + isEvenNumber.test(8.0) + "]");
	}

	public void function() {

		Function<Double, Double> function = t -> {
			return t * 5;
		};

		System.out.println("Function - " + function.apply(10.0));
	}

	public void biFunction() {

		BiFunction<Double, Double, String> biFunction = (t, u) -> "Multiply the Value " + t * u;
		System.out.println("BiFunction -" + biFunction.apply(8.0, 8.0));
	}

	public void biConsumer() {
		BiConsumer<Double, Double> addition = (t, u) -> System.out.println("BiConsumer - " + (t + u));
		addition.accept(150.0, 245.0);
	}

	public void biPredicate() {

		BiPredicate<Double, Double> biPredicate = (t, u) -> {

			return t % 2 == 0 && u % 2 == 0;
		};

		System.out.println("BiPredicate - " + biPredicate.test(4.0, 7.0));
	}

	public void unaryOperator() {

		/** Unary Operator Same Like Function<Double, Double> */
		UnaryOperator<Double> unaryOperator = t -> t * 10;
		System.out.println("UnaryOperator -" + unaryOperator.apply(5.0));
	}

	public void binaryOperator() {

		/** Binary Operator Same Like BiFunction<Double, Double, Double> */
		BinaryOperator<Double> binaryOperator = (t, u) -> t * u;
		System.out.println("BinaryOperator - " + binaryOperator.apply(5.0, 8.0));
	}
}
