package com.saravanan.java8features.featuretype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.saravanan.java8features.common.Student;

public class StreamExample {

	public void stream() {

		List<Student> lstStudents = Arrays.asList(Student.builder("Saravanan", "CSE", 50000),
				Student.builder("Kumar", "IT", 40000), Student.builder("Kavin", "ECE", 60000),
				Student.builder("Arun", "IT", 50000), Student.builder("Vijay", "CSE", 50000));

		boolean anyMatch = lstStudents.stream().anyMatch(s -> s.getDepartment().equalsIgnoreCase("CSE"));
		System.out.println("DepartmentName 'CSE' Exist or Not [AnyMatch] - " + anyMatch);

		System.out.println(
				"All Student Fees Above 50000 [AllMatch] - " + lstStudents.stream().allMatch(s -> s.getFees() > 50000));

		System.out.println("Student Name Check [NoneMatch] - "
				+ lstStudents.stream().noneMatch(s -> s.getStudentName().equalsIgnoreCase("Saravanan")));

		List<Student> lstAboveFees50000 = lstStudents.stream().filter(s -> s.getFees() > 50000)
				.collect(Collectors.toList());
		System.out.println("List out Student Above 50000 fees [Filter] - " + lstAboveFees50000);

		List<String> lstDepartment = lstStudents.stream().map(s -> s.getDepartment()).distinct()
				.collect(Collectors.toList());

		System.out.println("List out Student Department Without Duplicate [Map, Distinct]- " + lstDepartment);

		Optional<Student> anyCseStudentDetails = lstStudents.stream()
				.filter(s -> s.getDepartment().equalsIgnoreCase("CSE")).findAny();

		System.out.println("Any One Cse StdentDetail [filter, FindAny] - " + anyCseStudentDetails.get());

		Optional<Student> findFirstAbove50000Student = lstStudents.stream().filter(s -> s.getFees() > 50000)
				.findFirst();

		System.out.println(
				"Find First Above 50000 Fees Student [filter, findFirst] - " + findFirstAbove50000Student.get());

		System.out.println("List out student Name Natural Order [Map, Sorted]"
				+ lstStudents.stream().map(s -> s.getStudentName()).sorted().collect(Collectors.toList()));

		System.out.println("List Out the Student Desc Order [Sorted, reversed]" + lstStudents.stream()
				.sorted(Comparator.comparing(Student::getStudentName).reversed()).collect(Collectors.toList()));

		System.out.println(
				"Skip 3 Student [Skip]" + lstStudents.stream().map(Student::getStudentName).sorted().skip(3).toList());

		System.out.println("List out any two Department [Limit] -" + lstStudents.stream().map(Student::getDepartment)
				.sorted().distinct().limit(2).collect(Collectors.toUnmodifiableList()));

		System.out.println("Using [peek] - " + lstStudents.stream().map(Student::getStudentName)
				.peek(s -> System.out.println("Before UpperCase " + s + "|")).map(s -> s.toUpperCase())
				.peek(s -> System.out.println("After UpperCase " + s + "|")).toList());

		System.out.println("Above 35000 fees Details [filter, toMap] - " + lstStudents.stream()
				.filter(s -> s.getFees() > 35000).collect(Collectors.toMap(Student::getStudentName, Student::getFees)));

		System.out.println("Department Wise Grouping By Student [groupingBy]- "
				+ lstStudents.stream().collect(Collectors.groupingBy(Student::getDepartment)));

		List<List<Student>> lstStudentDetails = Arrays.asList(
				Arrays.asList(Student.builder("Saravanan", "CSE", 25000), Student.builder("Kumar", "IT", 48000)),
				Arrays.asList(Student.builder("Kavin", "ECE", 35000), Student.builder("Arun", "Mech", 50000)),
				Arrays.asList(Student.builder("Vijay", "CSE", 28000)));

		System.out.println("Before FlatMap :- ");
		lstStudentDetails.forEach(System.out::println);
		System.out.println("After FlatMap :- ");
		lstStudentDetails.stream().flatMap(s -> s.stream()).forEach(System.out::println);

		Stream.iterate(1, i -> i + 1).limit(20).filter(i -> i % 2 == 0)
				.forEach(i -> System.out.println("Even Number -" + i));

		System.out.println("Maximum Fees Student Detail - " + lstStudentDetails.stream().flatMap(s -> s.stream())
				.max(Comparator.comparingDouble(Student::getFees)).get());

		System.out.println("Minimum Fees Student Detail - " + lstStudentDetails.stream().flatMap(s -> s.stream())
				.min(Comparator.comparingDouble(Student::getFees)).get());

		System.out.println("List to Set - " + lstStudents.stream().collect(Collectors.toSet()));

		System.out.println("List to Map :-");
		System.out.println(
				lstStudents.stream().collect(Collectors.toMap(Student::getStudentName, Student::getDepartment)));
		System.out
				.println(lstStudents.stream().collect(Collectors.toMap(Student::getStudentName, Function.identity())));

		System.out.println("Total Fees [SummarizingDouble]- " + lstStudentDetails.stream().flatMap(s -> s.stream())
				.collect(Collectors.summarizingDouble(Student::getFees)));
		System.out.println("Total Fees [SummingDouble]- " + lstStudentDetails.stream().flatMap(s -> s.stream())
				.collect(Collectors.summingDouble(Student::getFees)));
		System.out.println("Total Fees [Sum] - " + lstStudentDetails.stream()
				.flatMapToDouble(s -> s.stream().flatMapToDouble(student -> DoubleStream.of(student.getFees()))).sum());
		System.out
				.println("Total Fees [mapToDouble, sum] - " + lstStudents.stream().mapToDouble(Student::getFees).sum());

		lstStudentDetails.stream().flatMapToDouble(s -> s.stream().mapToDouble(st -> st.getFees()));

		System.out.println("List to Array [toArray]-" + Arrays.toString(lstStudents.stream().toArray()));

		System.out.println(
				"joining - " + lstStudents.stream().map(Student::getStudentName).collect(Collectors.joining()));
		System.out.println("joining Seperator - "
				+ lstStudents.stream().map(Student::getStudentName).collect(Collectors.joining(" | ")));
		System.out.println("joining Seperator, Prefix, Suffix - "
				+ lstStudents.stream().map(Student::getStudentName).collect(Collectors.joining(" | ", " { ", " } ")));

		/** Take the Number While Condition Satisfied. */
		System.out.println("Take While -" + Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).takeWhile(i -> i < 6).toList());

		/** Drop the Number While Condition Satisfied. */
		System.out.println("Drop While -" + Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).dropWhile(i -> i < 6).toList());

		System.out.println("Reduce - " + lstStudents.stream().map(Student::getFees).reduce((t, u) -> t + u));
		Optional<Double> reduce = lstStudents.stream().map(Student::getFees).reduce((t, u) -> t + u);

		try {
			System.out.println("Create Stream Using of :- ");
			Stream.of(null);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(Stream.of("Saravanan", "Kumar", "Kavin", "Arun").sorted(Comparator.reverseOrder()).toList());
		Stream.ofNullable(null).forEach(System.out::println);
	}

	public void hashMapStream() {

		Map<String, List<String>> map = new HashMap<>();
		map.put("fruits", Arrays.asList("Mango", "Banana", "Apple"));
		map.put("Colors", Arrays.asList("Blue", "Green", "Red"));
		map.put("Vegetables", Arrays.asList("Carrot", "broccoli"));

		List<String> lstValues = map.values().stream().flatMap(m -> m.stream()).collect(Collectors.toList());
		System.out.println("Get Values [FlatMap] -: " + lstValues);

		System.out.println("Iterator -: ");
		map.entrySet().stream().forEach(m -> System.out.println("Key - " + m.getKey() + " : Value - " + m.getValue()));

		System.out.println("Get Key Only [ForEach]- " + map.keySet().stream().collect(Collectors.toList()));

		System.out
				.println("Get Value Start With Letter B [Map,Filter]-: " + map
						.entrySet().stream().map(m -> m.getValue().stream()
								.filter(s -> s.substring(0, 1).equalsIgnoreCase("B")).collect(Collectors.toList()))
						.collect(Collectors.toList()));

		System.out.println("Get Banana Contain Value - : " + map.entrySet().stream()
				.filter(m -> m.getValue().contains("Banana")).map(Map.Entry::getValue).collect(Collectors.toList()));

		Iterator<Entry<String, List<String>>> iterator = map.entrySet().iterator();
		System.out.println("Iterator - : ");
		while (iterator.hasNext()) {
			Entry<String, List<String>> next = iterator.next();
			System.out.println(next.getKey() + " : " + next.getValue());
		}

		System.out.println("Take While in Value - : " + map
				.entrySet().stream().map(m -> m.getValue().stream()
						.takeWhile(t -> t.substring(0, 1).equalsIgnoreCase("B")).collect(Collectors.toList()))
				.collect(Collectors.toList()));

		System.out.println("Drop While in Value - : " + map
				.entrySet().stream().map(m -> m.getValue().stream()
						.dropWhile(t -> t.substring(0, 1).equalsIgnoreCase("B")).collect(Collectors.toList()))
				.collect(Collectors.toList()));

		System.out.println(
				map.values().stream().collect(Collectors.groupingBy(s -> s.contains("Mango"), Collectors.toList())));

		Set<Map.Entry<String, List<String>>> entrySet = map.entrySet();
		Set<String> keySet = map.keySet();
		Collection<List<String>> values = map.values();

		/** Find Second highest Word in the sentence */
		String str = "i am a good programmer";
		String[] split = str.split(" ");
		Map<String, Integer> map1 = new HashMap<>();
		for (String string : split) {
			map1.put(string, string.length());
		}

		/** case : 1 */
		Entry<String, Integer> entry = map1.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).skip(1).findFirst().get();

		System.out.println(entry.getKey());

		/** case : 2 */
		Map<String, Integer> collect = map1.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(t -> t.getKey(), t -> t.getValue(), (t, u) -> u, LinkedHashMap::new));

		int count = 0;
		for (String key : collect.keySet()) {
			++count;
			if (count == 2) {
				System.out.println(key);
				break;
			}
		}
		/***/

	}

	public void example() {

		List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 2, 1));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));

		List<Integer> list3 = list1.stream().filter(l -> list2.contains(l)).collect(Collectors.toList());

		list2.removeAll(list3);
		list1.addAll(list2);

		List<Integer> list5 = list1.stream().distinct().sorted().collect(Collectors.toList());

		Map<Object, Long> map3 = list1.stream().collect(Collectors.groupingBy(l -> l, Collectors.counting()));

		/*************************/

		String name = "saravanan";
		Map<Character, Long> collect3 = name.chars().mapToObj(n -> (char) n)
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));

		Map<Character, Integer> lengthOfChar = new HashMap<>();
		for (int i = 0; i < name.length(); i++) {

			lengthOfChar.put(name.charAt(i), lengthOfChar.getOrDefault(name.charAt(i), 0) + 1);
		}

		/**
		 * Third Longest Word in List 'Check Descending Order Third Word.'
		 */

		List<String> lstFruits = Arrays.asList("Apple", "Orange", "Banana", "Mango", "Cherry", "rgdrsghdhdjhd");
		lstFruits.stream().sorted((o1, o2) -> Integer.compare(o2.length(), o1.length())).skip(2).findFirst()
				.ifPresent(System.out::println);

		/** Find the Longest Word in List */
		lstFruits.stream().max(Comparator.comparingInt(value -> value.length())).ifPresent(t -> System.out.println(t));

		/** Find the Longest Number in List */
		List<Integer> lstMaxNumber = Arrays.asList(25, 65, 98, 787, 66, 956, 626);
		lstMaxNumber.stream().sorted(Comparator.reverseOrder()).findFirst().ifPresent(System.out::println);

		/** Summary Statics */
		List<Integer> lstInteger = Arrays.asList(25, 65, 98, 787, 66, 956, 626);
		IntSummaryStatistics summaryStatistics = lstInteger.stream().mapToInt(value -> value).summaryStatistics();
		IntSummaryStatistics collect = lstInteger.stream().collect(Collectors.summarizingInt(value -> value));

		System.out.println("Min - " + summaryStatistics.getMin());
		System.out.println("Max - " + summaryStatistics.getMax());
		System.out.println("Sum - " + summaryStatistics.getSum());
		System.out.println("Average - " + summaryStatistics.getAverage());
		System.out.println("Count - " + summaryStatistics.getCount());

		/** First Repeating Letter */
		String word = new String("saravanan");
		word.chars().mapToObj(value -> (char) value)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(t -> t.getValue() > 1).map(t -> t.getKey()).findFirst().ifPresent(s -> System.out.println(s));

		/**
		 * First Non Repeating Letter
		 * 
		 * Case 1 :-
		 */
		word.chars().mapToObj(value -> (char) value)
				.collect(Collectors.groupingBy(t -> t, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(t -> t.getValue() == 1).map(Map.Entry::getKey).findFirst().ifPresent(System.out::println);

		/** Case 2 :- */
		String input = "swiss";
		Character result = input.chars().mapToObj(c -> (char) c)
				.filter(ch -> input.indexOf(ch) == input.lastIndexOf(ch)).findFirst().orElse(null);
		System.out.println(result);

		for (int i = 0; i < input.length(); i++) {
			if (input.indexOf(input.charAt(i)) == input.lastIndexOf(input.charAt(i))) {
				System.out.println(input.charAt(i));
				break;
			}
		}

		/** Sum of UniqueNumbers */
		List<Integer> lstNumber = Arrays.asList(45, 25, 45, 28, 99, 88, 25);
		int sum = lstNumber.stream().distinct().mapToInt(value -> value).sum();
		System.out.println(sum);

		/** Sum of Without Duplicate Value */
		Map<Integer, Long> collect2 = lstNumber.stream().collect(Collectors.groupingBy(t -> t, Collectors.counting()));
		int sum2 = collect2.entrySet().stream().filter(t -> t.getValue() == 1).mapToInt(Map.Entry::getKey).sum();
		System.out.println(sum2);

		/** Find the Vowels word in Two and Above Letters. */
		String vowelsSentence = "Education opens up opportunities";

		List<String> lstVowelsLetter = Arrays.stream(vowelsSentence.split(" "))
				.filter(v -> findCountVowelLetter(v) >= 2).collect(Collectors.toList());
		lstVowelsLetter.forEach(System.out::println);

		/** Sum Of First Two Number */
		int sumTwoNumber = lstNumber.stream().limit(2).mapToInt(value -> value).sum();
		System.out.println(sumTwoNumber);

		/** Find The Third Number Natural Order. */
		int[] arrInt = { 12, 6, 989, 45, 64, 78 };
		Arrays.stream(arrInt).sorted().skip(2).findFirst().ifPresent(System.out::println);

		/** Find the include Number word */
		List<String> lstIncludeNum = Arrays.asList("10Banana", "21Apple", "Orange", "Cherry", "Mango", "Strabery58");

		List<String> lstFindDigitInWord = lstIncludeNum.stream()
				.filter(s -> s.chars().mapToObj(c -> (char) c).filter(sc -> Character.isDigit(sc)).count() > 0)
				.toList();
		lstFindDigitInWord.forEach(System.out::println);

		/** Remove Number in the Word */
		List<String> lstRemoveDigitInWord = lstIncludeNum.stream()
				.map(s -> s.chars().filter(sc -> !Character.isDigit(sc)).mapToObj(c -> String.valueOf((char) c))
						.collect(Collectors.joining()))
				.toList();
		lstRemoveDigitInWord.forEach(System.out::println);

		/** Print Non Null And Start With 4 */
		List<Integer> lstNumberWithNull = Arrays.asList(56, null, 5862, null, 55, 555, 44, null);
		lstNumberWithNull.stream().filter(t -> t != null && String.valueOf(t).startsWith("4")).toList()
				.forEach(System.out::println);

		/** Partition By Prime Number And Non Prime Number */
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
		Map<Boolean, List<Integer>> partitioned = numbers.stream()
				.collect(Collectors.partitioningBy(num -> isPrime(num)));
		System.out.println(partitioned);

		/** Factorial */
		int factorial = IntStream.rangeClosed(1, 5).reduce(1, (a, b) -> a * b);
		System.out.println(factorial);

		/**
		 * highest element to the right of each element input - { 16, 17, 4, 3, 5, 2 }
		 * output - {17, 5, 5, 5, 2, -1}
		 **/
		int[] value = { 16, 17, 4, 3, 5, 2 };

		List<Integer> finalValue = new ArrayList<>();
		for (int i = 0; i < value.length; i++) {

			int max = -1;
			for (int j = i + 1; j < value.length; j++) {

				if (max < value[j]) {
					max = value[j];
				}
			}

			finalValue.add(max);
		}

		System.out.println(finalValue);

		/**
		 * Reverse the String
		 * 
		 * Case - 1
		 */
		String reversWord = "Saravanan";
		Optional<String> reduce = reversWord.chars().mapToObj(v -> String.valueOf((char) v)).reduce((t, u) -> u + t);
		System.out.println(reduce.get());

		/** Case - 2 */
		String reverseWordIntStream = IntStream.rangeClosed(1, reversWord.length()).peek(System.out::println)
				.mapToObj(s -> reversWord.charAt(reversWord.length() - s)).map(String::valueOf)
				.collect(Collectors.joining());
		System.out.println(reverseWordIntStream);

		/** Case - 3 */
		String reverseWordIterator = "";
		for (int i = reversWord.length() - 1; i >= 0; i--) {

			reverseWordIterator += reversWord.charAt(i);
		}
		System.out.println(reverseWordIterator);

		/**
		 * MobileNo is Fancy Number or Not. Fancy Number :- 1. Same Number Three Time
		 * Continuity 2. Ascending Order Or Descending Order Three Number
		 */

		String number = "92123542987";

		int lastNo = -1;
		int count = 0;
		List<Integer> asecOrder = new ArrayList<>();
		List<Integer> desecOrder = new ArrayList<>();
		for (int i = 0; i < number.length(); i++) {

			int num = Integer.parseInt(String.valueOf(number.charAt(i)));

			if (lastNo == num) {
				count++;
			} else if (count != 0 && count < 2) {
				count = 0;
			}

			lastNo = num;

			asecOrder.add(num);
			desecOrder.add(num);
		}

		lastNo = -1;
		int asecCount = 0;
		for (Integer num : asecOrder) {

			if (lastNo != -1 && lastNo + 1 == num) {
				asecCount++;
			} else if (asecCount <= 2) {
				asecCount = 0;
			}

			lastNo = num;

		}

		lastNo = -1;
		int desecCount = 0, numContinuity = 0;
		for (int i = desecOrder.size() - 1; i >= 0; i--) {

			if (numContinuity != 0)
				numContinuity++;

			boolean isValid = false;
			int num = desecOrder.get(i);
			if (lastNo != -1 && lastNo + 1 == num) {
				desecCount++;
				if (numContinuity == 0)
					numContinuity++;
				isValid = true;
			} else if (desecCount < 2) {
				desecCount = 0;
			}

			if ((numContinuity == 2 || numContinuity == 3) && !isValid) {
				desecCount = 0;
				numContinuity = 0;
			}

			lastNo = num;

			if (desecCount >= 2)
				break;

		}

		System.out.print(asecCount >= 2 || desecCount >= 2 || count >= 2 ? "Is Fancy Number" : "Is Not Fancy Number");
		/***/

		/***/
		List<Student> lstStudents = Arrays.asList(Student.builder("Saravanan", "CSE", 50000),
				Student.builder("Kumar", "IT", 40000), Student.builder("Kavin", "ECE", 60000),
				Student.builder("Arun", "IT", 50000), Student.builder("Vijay", "CSE", 50000));

	}

	static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		/*
		 * return IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(n -> num % n
		 * == 0);
		 */
		return IntStream.rangeClosed(2, num - 1).noneMatch(n -> num % n == 0);
	}

	private long findCountVowelLetter(String vowels) {

		return vowels.chars().mapToObj(c -> (char) c).filter(v -> "aeiouAEIOU".indexOf(v) != -1).count();
	}

}
