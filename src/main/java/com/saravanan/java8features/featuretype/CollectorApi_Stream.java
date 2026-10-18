package com.saravanan.java8features.featuretype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.saravanan.java8features.common.Student;

public class CollectorApi_Stream {

	public void collectorApi() {

		List<Student> lstStudent = Arrays.asList(Student.builder("Saravanan", "CSE", 55000),
				Student.builder("Kumar", "CSE", 45000), Student.builder("Kavin", "IT", 50000),
				Student.builder("Arun", "ECE", 45000), Student.builder("Vijay", "IT", 50000));

		double averageFees = lstStudent.stream().collect(Collectors.averagingDouble(Student::getFees)).doubleValue();
		System.out.println("Student Average Fees - " + averageFees);

		double summarizeFees = lstStudent.stream().collect(Collectors.summingDouble(Student::getFees)).doubleValue();
		System.out.println("Student Summarize Fees - " + summarizeFees);

		DoubleSummaryStatistics summaryStatistics = lstStudent.stream()
				.collect(Collectors.summarizingDouble(Student::getFees));

		List<Integer> lstIntegers = Arrays.asList(3, 5, 6, 7, 8);

		Optional<Integer> max = lstIntegers.stream().max(Comparator.comparingInt(value -> value));
		max = lstIntegers.stream().max((o1, o2) -> Integer.compare(o1, o2));
		Integer collect = lstIntegers.stream().collect(Collectors.summingInt(value -> value));

		System.out.println("Summary Fees Details -" + summaryStatistics);

		System.out.println("Unmodifiable List :- ");
		List<Student> lstStud = lstStudent.stream().collect(Collectors.toUnmodifiableList());
		System.out.println(lstStud);
		System.out.println(lstStudent.stream()
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)));

		System.out.println("Collectors collectingAndThen - "
				+ lstStudent.stream().collect(Collectors.collectingAndThen(Collectors.toSet(),
						s -> s.stream().map(Student::getDepartment).distinct().toList())));

		System.out.println("List to Set - " + lstStudent.stream().collect(Collectors.toSet()));
		System.out.println("List to Map - "
				+ lstStudent.stream().collect(Collectors.toMap(Student::getStudentName, Function.identity())));

		System.out.println("Collectors Grouping By - "
				+ lstStudent.stream().collect(Collectors.groupingBy(Student::getDepartment)));

		System.out.println("Collectors Grouping By And SummingDouble- " + lstStudent.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, Collectors.summingDouble(Student::getFees))));

		System.out.println("Collectors Grouping By And Return Type- "
				+ lstStudent.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.toSet())));

		Map<String, Set<Student>> collectMap = lstStudent.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, Collectors.mapping(s -> s, Collectors.toSet())));

		System.out.println("Collectors Grouping By And Mapping - " + collectMap);

		System.out.println("Joining - "
				+ lstStudent.stream().map(Student::getDepartment).distinct().collect(Collectors.joining()));
		System.out.println("Joining With Seperator - "
				+ lstStudent.stream().map(Student::getDepartment).distinct().collect(Collectors.joining("|")));
		System.out.println("Joining With Seperator - " + lstStudent.stream().map(Student::getDepartment).distinct()
				.collect(Collectors.joining("|", "[", "]")));

		System.out.println("Maximum Fees Details :- ");
		System.out.println(
				lstStudent.stream().map(Student::getFees).collect(Collectors.maxBy(Comparator.naturalOrder())).get());
		System.out.println(
				lstStudent.stream().map(Student::getFees).collect(Collectors.maxBy(Comparator.reverseOrder())).get());
		System.out
				.println(lstStudent.stream().map(Student::getFees).collect(Collectors.maxBy(Double::compareTo)).get());

		System.out.println("Minimum Fees Details :- ");
		System.out.println(
				lstStudent.stream().map(Student::getFees).collect(Collectors.minBy(Comparator.naturalOrder())).get());
		System.out.println(
				lstStudent.stream().map(Student::getFees).collect(Collectors.minBy(Comparator.reverseOrder())).get());
		System.out
				.println(lstStudent.stream().map(Student::getFees).collect(Collectors.minBy(Double::compareTo)).get());

		System.out.println("Collection Partitioning "
				+ lstStudent.stream().collect(Collectors.partitioningBy(s -> s.getFees() > 50000)));
		System.out.println("Collection Partitioning And Return Type"
				+ lstStudent.stream().collect(Collectors.partitioningBy(s -> s.getFees() > 15000, Collectors.toSet())));

		System.out.println("Summarize Fees for Department Cse - "
				+ lstStudent.stream().collect(Collectors.partitioningBy(s -> s.getDepartment().equalsIgnoreCase("CSE"),
						Collectors.summingDouble(Student::getFees))));

		System.out.println("Reduce in Collectors - "
				+ lstStudent.stream().map(s -> s.getFees()).collect(Collectors.reducing((t, u) -> t + u)).get());

		List<Integer> lstfees = Arrays.asList(5000, 10000, 2548, 1500, 24000);

		System.out.println("Collectors SummarizingDouble - "
				+ lstfees.stream().collect(Collectors.summarizingDouble(value -> value)));

		System.out.println(
				"Collectors SummarizingInt - " + lstfees.stream().collect(Collectors.summarizingInt(value -> value)));

		System.out.println(
				"Collectors SummarizingLong - " + lstfees.stream().collect(Collectors.summarizingLong(value -> value)));

		System.out.println("Collectors SummingDouble - "
				+ lstfees.stream().collect(Collectors.summingDouble(value -> value)).doubleValue());

		System.out.println("Collectors SummingInt - "
				+ lstfees.stream().collect(Collectors.summingInt(value -> value)).intValue());

		System.out.println("Collectors SummingLong - "
				+ lstfees.stream().collect(Collectors.summingLong(value -> value)).longValue());

		System.out.println("Student Details Count :- ");
		System.out.println(lstStudent.stream().count());
		System.out.println(lstStudent.stream().collect(Collectors.counting()));

		System.out.println("Collectors Teeing :- ");
		System.out.println(lstStudent.stream()
				.collect(Collectors.teeing(Collectors.maxBy(Comparator.comparing(Student::getFees)),
						Collectors.minBy(Comparator.comparing(Student::getFees)),
						(t, u) -> t.get().getFees() + u.get().getFees())));

		System.out.println("Collector Filter :- ");
		System.out.println(lstStudent.stream()
				.collect(Collectors.filtering(s -> s.getDepartment().equalsIgnoreCase("IT"), Collectors.toSet())));

		List<List<Student>> lstInnerStudentDetails = Arrays.asList(
				Arrays.asList(Student.builder("Saravanan", "CSE", 19000)),
				Arrays.asList(Student.builder("Kavin", "IT", 29000), Student.builder("Kumar", "IT", 29000)));

		System.out.println("Collectors FlatMapping - " + lstInnerStudentDetails.stream()
				.collect(Collectors.flatMapping(s -> s.stream(), Collectors.toUnmodifiableList())));

		System.out.println("Collectors Mapping - " + lstStudent.stream()
				.collect(Collectors.mapping(s -> s.getStudentName().toUpperCase(), Collectors.toUnmodifiableList())));

		System.out.println(
				"Collectors toUnmodifiableSet - " + lstStudent.stream().collect(Collectors.toUnmodifiableSet()));

		System.out.println("Collectors toUnmodifiableMap - "
				+ lstStudent.stream().collect(Collectors.toUnmodifiableMap(Student::getStudentName, s -> s)));

		System.out.println(
				"Colletors ToCollection - " + lstStudent.stream().collect(Collectors.toCollection(ArrayList::new)));

		System.out.println("Colletors ConcurrentMap - " + lstStudent.stream()
				.collect(Collectors.toConcurrentMap(Student::getStudentName, Student::getDepartment)));

		/**
		 * write a solution to find the top 2 highest Fees Above 40000 fees for each
		 * department by totalFees ( descending )
		 */
		Map<String, List<Student>> collect2 = lstStudent.stream().filter(t -> t.getFees() > 40000)
				.collect(Collectors.groupingBy(t -> t.getDepartment(),
						Collectors.collectingAndThen(Collectors.toList(),
								t -> t.stream().sorted(Comparator.comparingDouble(Student::getFees).reversed()).limit(2)
										.collect(Collectors.toList()))));

		System.out.println(collect2);

		/** write a solution to find the highest paid student in each dept */

		Map<String, Optional<Student>> collect3 = lstStudent.stream().collect(Collectors
				.groupingBy(t -> t.getDepartment(), Collectors.maxBy(Comparator.comparingDouble(Student::getFees))));

		System.out.println(collect3);
	}

}
