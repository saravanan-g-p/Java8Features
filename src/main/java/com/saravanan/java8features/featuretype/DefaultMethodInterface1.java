package com.saravanan.java8features.featuretype;

public interface DefaultMethodInterface1 {

	public void multiplyValue(double i, double j);

	default String defaultMethod() {
		return "Calling Default Method";
	}

	public static String staticMethod() {
		return "Calling Static Method";
	}

}
