package com.saravanan.java8features.featuretype;

public class MethodReference {

	public MethodReference() {
		System.out.println("Called Constructor Using Method Reference");
	}

	public MethodReference(String value) {
		System.out.print(value + " | ");
	}

	public double addition(double i, double j) {
		return i + j;
	}

	public static double multiplication(double i, double j) {
		return i * j;
	}

	public static void getNumber(int i) {
		System.out.print(i + " -> ");
	}

}
