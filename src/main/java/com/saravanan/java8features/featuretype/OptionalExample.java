package com.saravanan.java8features.featuretype;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.saravanan.java8features.common.Student;

public class OptionalExample {

	public void optionalExample() {

		Optional<String> optionalEmpty = Optional.empty();
		Optional<Student> optionalStudent = Optional.of(Student.builder("Saravanan", "CSE", 25000));
		Optional<String> optionalNullable = Optional.ofNullable(null); // it's
																		// Allow
																		// Null

		System.out.println("Optional Creation Using Empty - " + optionalEmpty);
		System.out.println("Optional Creation Using of - " + optionalStudent);
		System.out.println("Optional Creation using ofNullable - " + optionalNullable);

		System.out.println("Value Is Present Or Not - " + optionalEmpty.isPresent());
		System.out.println("get Value [get] - " + optionalStudent.get());
		System.out.println("OrElse Function - " + optionalEmpty.orElse("Saravanan"));
		System.out.println("orElseGet Function - " + optionalEmpty.orElseGet(() -> "Saravanan"));
		try {
			optionalNullable.orElseThrow(() -> new Exception("No Value Found."));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println("check IsEmpty - " + optionalEmpty.isEmpty());
		optionalEmpty.ifPresent(t -> System.out.println("Value is [ifPresent]" + t));
		optionalNullable.ifPresentOrElse(t -> System.out.println("Value is - [ifPresentOrElse]" + t), () -> System.out
				.println("No Value Found."));

		System.out.println("Using map - " + optionalStudent.map(Student::getFees).get());

		System.out.println("Get CSE Department Student Details [Filter] - " + optionalStudent.filter(s -> s
				.getDepartment().equalsIgnoreCase("CSE")));

		Optional<List<List<Student>>> optionalStudentDetails = Optional.of(Arrays.asList(Arrays.asList(Student.builder(
				"Saravanan", "CSE", 25000)), Arrays.asList(Student.builder("Kumar", "CSE", 25000))));

		Optional<List<Student>> lstStudentDetails = optionalStudentDetails.flatMap(s -> Optional.of(s.stream().flatMap(
				t -> t.stream()).toList()));

		lstStudentDetails = optionalStudentDetails.flatMap(s -> Optional.of(s.stream().flatMap(List::stream).toList()));

		System.out.println("get Student Details - " + lstStudentDetails.get());
	}
}
