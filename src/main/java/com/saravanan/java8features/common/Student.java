package com.saravanan.java8features.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "builder")
@NoArgsConstructor
public class Student {

	private String studentName;
	private String department;
	private double fees;

}
