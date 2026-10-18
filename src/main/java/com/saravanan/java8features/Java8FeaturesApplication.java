package com.saravanan.java8features;

import java.util.TreeMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saravanan.java8features.common.FeatureType;
import com.saravanan.java8features.featuretype.Base64EncoderAndDecoder;
import com.saravanan.java8features.featuretype.CollectorApi_Stream;
import com.saravanan.java8features.featuretype.CommonProgramQns;
import com.saravanan.java8features.featuretype.DateTimeApiExample;
import com.saravanan.java8features.featuretype.DefaultMethod;
import com.saravanan.java8features.featuretype.DefaultMethodInterface;
import com.saravanan.java8features.featuretype.FunctionalInterfaceExample;
import com.saravanan.java8features.featuretype.LamdaExpression;
import com.saravanan.java8features.featuretype.MethodReferenceExample;
import com.saravanan.java8features.featuretype.OptionalExample;
import com.saravanan.java8features.featuretype.ParameterReflection;
import com.saravanan.java8features.featuretype.StreamExample;
import com.saravanan.java8features.featuretype.StringJoinerExample;
import com.saravanan.java8features.functionalinterface.MultiplyTwoNumber;

@SpringBootApplication
public class Java8FeaturesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java8FeaturesApplication.class, args);
		featureExecuter(FeatureType.COMMON_PROGRAM_QNS);

	}

	private static void featureExecuter(FeatureType featureType) {
		try {

			switch (featureType) {
			case COMMON_PROGRAM_QNS: {

				CommonProgramQns commonProgramQns = new CommonProgramQns();
				commonProgramQns.commonProgram();
				break;
			}
			case LAMBDA: {
				LamdaExpression lamdaExpression = new LamdaExpression();
				lamdaExpression.multiplyValue();
				lamdaExpression.iterator();
				TreeMap<String, Object> treeMap = new TreeMap<>();

				treeMap.put(null, treeMap);

				break;
			}
			case FUNCTIONAL_INTERFACE: {
				FunctionalInterfaceExample functionalInterface = new FunctionalInterfaceExample();
				functionalInterface.consumer();
				functionalInterface.biConsumer();
				functionalInterface.supplier();
				functionalInterface.predicate();
				functionalInterface.biPredicate();
				functionalInterface.function();
				functionalInterface.biFunction();
				functionalInterface.unaryOperator();
				functionalInterface.binaryOperator();
				break;
			}
			case FUNCTIONAL_INTERFACE_ANNOTATION: {

				MultiplyTwoNumber multiplyTwoNumber = (i, j) -> i * j;
				System.out.println("Multiply Two Number - " + multiplyTwoNumber.multiplyvalue(5.0, 4.0));
			}
			case DEFAULT_METHODS_IN_INTERFACE: {
				DefaultMethod defaultMethod = new DefaultMethod();
				defaultMethod.multiplyValue(5.0, 6.0);
				System.out.println(defaultMethod.defaultMethod());
				System.out.println(DefaultMethodInterface.staticMethod());
				System.out.println(DefaultMethod.class.getName());
			}
			case BASE64_ENCODE_DECODE: {
				Base64EncoderAndDecoder base64EncoderAndDecoder = new Base64EncoderAndDecoder();
				String encryptMessage = base64EncoderAndDecoder.encryptMessage("Saravanan K");
				base64EncoderAndDecoder.decryptMessage(encryptMessage);
				break;
			}
			case STREAM: {
				StreamExample streamExample = new StreamExample();
				streamExample.stream();
				streamExample.hashMapStream();
				streamExample.example();
				break;
			}
			case COLLECTORS_API: {

				CollectorApi_Stream collectorApi_Stream = new CollectorApi_Stream();
				collectorApi_Stream.collectorApi();
				break;
			}
			case STRING_JOINER: {
				StringJoinerExample stringJoinerExample = new StringJoinerExample();
				stringJoinerExample.stringJoiner();
				break;
			}
			case OPTIONAL_CLASS: {
				OptionalExample optionalExample = new OptionalExample();
				optionalExample.optionalExample();
				break;
			}
			case DATE_TIME_API: {
				DateTimeApiExample dateTimeApiExample = new DateTimeApiExample();
				dateTimeApiExample.dataTimeApi();
				break;
			}
			case METHOD_REFERENCE: {
				MethodReferenceExample methodReferenceExample = new MethodReferenceExample();
				methodReferenceExample.methodReference();
				break;
			}
			case PARAMETER_REFLECTION: {
				ParameterReflection parameterReflection = new ParameterReflection();
				parameterReflection.parameterReflection();
				break;
			}
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
