package com.edu.abhi.concurrency.inpractice.sharingobjects3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Immutable {
	public final ClassA A = new ClassA(); 
	
	public static void main(String[] args) {
		Immutable  i = new Immutable();
		System.out.println(i.A.getList());
		i.A.getList().add("D");
		i.A.getList().add("E");
		System.out.println(i.A.getList());

	}

	public ClassA getA() {
		return A;
	}

}

class ClassA{
	private List<String> list = new ArrayList<String>();
	public ClassA(){
		list.add("A");
		list.add("B");
		list.add("C");
	}
	public List<String> getList() {
		List<String> tempList = new ArrayList<String>();
		tempList.addAll(list);
		return tempList;
		//return list; // to make ClassA list as Immutable
		
	}
}