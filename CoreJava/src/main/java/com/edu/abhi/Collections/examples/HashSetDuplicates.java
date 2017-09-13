package com.edu.abhi.Collections.examples;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * The hashCode() and equals() method should represent the same value for
 * same objects.
 * 
 * @author abhishekkhare
 *
 */
public class HashSetDuplicates {

	public static void main(String[] args) {
		Set<TestClass> test = new HashSet<TestClass>();
		test.add(new TestClass("ABC", "1"));
		test.add(new TestClass("DEF", "2"));
		test.add(new TestClass("EFG", "3"));
		test.add(new TestClass("PQR", "4"));
		test.add(new TestClass("XYZ", "5"));
		test.add(new TestClass("ABC", "1"));
		System.out.println(test.size());
		for (TestClass testClass : test) {
			System.out.println(testClass);
		}
	}

}

class TestClass {
	private String name;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TestClass(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public int hashCode() {
		Random random = new Random();
		return random.nextInt();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestClass other = (TestClass) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TestClass [name=" + name + ", id=" + id + "]";
	}

}