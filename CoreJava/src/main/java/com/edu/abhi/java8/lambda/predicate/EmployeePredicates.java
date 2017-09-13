package com.edu.abhi.java8.lambda.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {
	/**
	 * Checks if the age of employee > 21 and the gender == M
	 * 
	 * @return
	 */
	public static Predicate<Employee> isAdultMale() {
		return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
	}

	/**
	 * Checks if the age of employee > 21 and the gender == F
	 * 
	 * @return
	 */
	public static Predicate<Employee> isAdultFemale() {
		return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
	}

	/**
	 * Checks if the age of employee > then input age
	 * @param age
	 * @return
	 */
	public static Predicate<Employee> isAgeMoreThan(Integer age) {
		return p -> p.getAge() > age;
	}

	/**
	 * 
	 * @param employees
	 * @param predicate
	 * @return
	 */
	public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream().filter(predicate).collect(Collectors.<Employee> toList());
	}
}
