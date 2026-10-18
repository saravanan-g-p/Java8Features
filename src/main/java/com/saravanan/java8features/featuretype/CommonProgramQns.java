package com.saravanan.java8features.featuretype;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CommonProgramQns {

	public void commonProgram() throws Exception {
		try {

			/**
			 * Given an array, rotate it to the right by k steps. Input: nums =
			 * [1,2,3,4,5,6,7], k = 3 Output: [5,6,7,1,2,3,4]
			 */

			int[] num = { 1, 2, 3, 4, 5, 6, 7 };
			int k = 3;

			int[] num1 = new int[num.length];
			int j = num.length - k;
			int count = 0;

			for (int i = 0; i < num.length; i++) {
				count++;

				if (count <= k) {
					num1[i] = num[j];
					if (count == k) {
						j = 0;
					} else {
						j++;
					}
				} else {

					num1[i] = num[j];
					j++;
				}
			}

			System.out.println(Arrays.toString(num1));
			/***/

			/**
			 * Given string s , find the length of the longest substring without duplicate
			 * characters
			 */
			lengthOfLongestSubstring();

			/**
			 * Given an integer array nums and an integer k , return the total number of
			 * continuous subarrays whose sum equals k
			 */
			subarraySum();

			/** Reverse String */
			reverse_String();

			/** Check Palindrome String */
			check_Palindrome_String();

			/** Reverse a Number */
			reverse_a_Number();

			/** Check Palindrome Number */
			check_Palindrome_Number();

			/** Find Factorial of a Number */
			find_Factorial_of_a_Number();

			/** Fibonacci Series */
			fibonacci_Series();

			/** Check Prime Number */
			check_Prime_Number();

			/** Find Largest of 3 Numbers */
			find_Largest_of_Numbers();

			/** Swap Two Numbers (Without Temp) */
			swap_Two_Numbers_Without_Temp();

			/** Count Digits in a Number */
			count_Digits_in_a_Number();

			/** Remove Duplicate Characters from String */
			remove_Duplicate_Characters_from_String();

			/** Find Duplicate Elements in Array */
			find_Duplicate_Elements_in_Array();

			/** Sort Array Without Built-in Method */
			sort_Array_Without_Built_in_Method();

			/** Find Second Largest Number in Array */
			find_Second_Largest_Number_in_Array();

			/** Check Anagram */
			check_Anagram();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static int subarraySum() {

		int[] nums = { 1, 1, 1 };
		int k = 2;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1); // base case

		int sum = 0;
		int count = 0;

		for (int num : nums) {
			sum += num;

			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

	private void lengthOfLongestSubstring() {

		String s = "mttmtt";
		Set<Character> set = new LinkedHashSet<>();
		int j = 0, maxLength = 0;

		for (int i = 0; i < s.length(); i++) {

			char current = s.charAt(i);

			// If duplicate found, shrink window from left
			while (set.contains(current)) {
				set.remove(s.charAt(j));
				j++;
			}

			// Add current character
			set.add(current);

			// Update maximum length
			maxLength = Math.max(maxLength, i - j + 1);
		}

		System.out.println(maxLength);
	}

	private void check_Anagram() {

		String s1 = "listen";
		String s2 = "silent";

		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();

		Arrays.sort(a1);
		Arrays.sort(a2);

		System.out.println(Arrays.equals(a1, a2));
	}

	private void find_Second_Largest_Number_in_Array() {

		int[] arr = { 10, 5, 20, 8 };
		int largest = -1;
		int second = -1;

		for (int i : arr) {
			if (i > largest) {
				second = largest;
				largest = i;
			} else if (i > second && i != largest) {
				second = i;
			}
		}
		System.out.println(second);
	}

	private void sort_Array_Without_Built_in_Method() {

		int[] arr = { 5, 2, 8, 1 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private void find_Duplicate_Elements_in_Array() {

		int[] arr = { 1, 2, 3, 2, 4, 3 };

		Set<Integer> set = new HashSet<>();

		for (int i : arr) {
			if (!set.add(i)) {
				System.out.println(i);
			}
		}
	}

	private void remove_Duplicate_Characters_from_String() {

		String str = "programming";
		String result = "";

		for (char c : str.toCharArray()) {
			if (!result.contains(String.valueOf(c))) {
				result += c;
			}
		}
		System.out.println(result);
	}

	private void count_Digits_in_a_Number() {

		int num = 12345;
		int count = 0;

		while (num != 0) {
			count++;
			num /= 10;
		}
		System.out.println(count);
	}

	private void swap_Two_Numbers_Without_Temp() {

		int a = 5, b = 10;

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println(a + " " + b);
	}

	private void find_Largest_of_Numbers() {

		int a = 10, b = 20, c = 15;

		int max = a > b ? (a > c ? a : c) : (b > c ? b : c);
		System.out.println(max);
	}

	private void check_Prime_Number() {

		int num = 7;
		boolean isPrime = true;

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.println(isPrime ? "Prime" : "Not Prime");
	}

	private void fibonacci_Series() {

		int n1 = 0, n2 = 1;

		for (int i = 1; i <= 10; i++) {
			System.out.print(n1 + " ");
			int sum = n1 + n2;
			n1 = n2;
			n2 = sum;
		}
	}

	private void find_Factorial_of_a_Number() {

		int n = 5;
		long fact = 1;

		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		System.out.println(fact);
	}

	private void check_Palindrome_Number() {

		int num = 121, temp = num, rev = 0;

		while (num != 0) {

			int digit = num % 10;
			rev = rev * 10 + digit;
			num /= 10;
		}

		System.out.println(temp == rev ? "Palindrome" : "Not Palindrome");
	}

	private void reverse_a_Number() {

		int num = 1234, rev = 0;

		while (num != 0) {

			int digit = num % 10;
			rev = rev * 10 + digit;
			num /= 10;
		}
		System.out.println(rev);
	}

	private void check_Palindrome_String() {

		String str = "madam";
		String rev = new StringBuilder(str).reverse().toString();

		if (str.equals(rev))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
	}

	private void reverse_String() {

		String str = "Java";
		String rev = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		}
		System.out.println(rev);
	}

}
