package com.saravanan.java8features.featuretype;

public class DefaultMethod implements DefaultMethodInterface, DefaultMethodInterface1 {

	@Override
	public void multiplyValue(double i, double j) {
		System.out.println("Multiply Value - " + i * j);
	}

	@Override
	public String defaultMethod() {
		return DefaultMethodInterface1.super.defaultMethod();
	}

	
}
