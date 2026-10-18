package com.saravanan.java8features.featuretype;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ParameterReflection {

	public void parameterReflection() {

		FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
		Class<?> functionalClass = functionalInterfaceExample.getClass();
		Field[] declaredFields = functionalClass.getDeclaredFields();
		Method[] declaredMethods = functionalClass.getDeclaredMethods();
		Annotation[] declaredAnnotations = functionalClass.getDeclaredAnnotations();

		System.out.println("declaredAnnotations - " + Arrays.toString(declaredAnnotations));
		System.out.println("declaredFields - " + Arrays.toString(declaredFields));
		System.out.println("declaredMethods - " + Arrays.toString(declaredMethods));

		System.out.println("CanonicalName - " + functionalClass.getCanonicalName());
		System.out.println("SimpleName - " + functionalClass.getSimpleName());
		System.out.println("PackageName - " + functionalClass.getPackageName());
		System.out.println("Name - " + functionalClass.getName());
		System.out.println("TypeName - " + functionalClass.getTypeName());
		System.out.println("isLocalClass - " + functionalClass.isLocalClass());
		System.out.println("isAnnotation - " + functionalClass.isAnnotation());
		System.out.println("isArray - " + functionalClass.isArray());
		System.out.println("isEnum - " + functionalClass.isEnum());
		System.out.println("isInterface - " + functionalClass.isInterface());
		System.out.println("isPrimitive - " + functionalClass.isPrimitive());
		System.out.println("isRecord - " + functionalClass.isRecord());
		System.out.println("isMemberClass - " + functionalClass.isMemberClass());
		System.out.println("isNestmateOf - " + functionalClass.isNestmateOf(LamdaExpression.class));
	}

}
