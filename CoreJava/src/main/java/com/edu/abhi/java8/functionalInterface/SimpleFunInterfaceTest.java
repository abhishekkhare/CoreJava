package com.edu.abhi.java8.functionalInterface;

/**
 * 
 * @author abhishekkhare
 *
 */
public class SimpleFunInterfaceTest {

	public static void main(String[] args) {
		carryOutWork(new SimpleFuncInterface() {
			@Override
			public void doWork() {
				System.out.println("Do work in SimpleFun impl...");
			}
		});
		
		carryOutWork(() -> System.out.println("Do work in lambda exp impl..."));
		
		System.out.println("*******************************");
		carryOutWork(new ComplexFunctionalInterface(){
			@Override
			public void doWork() {
				System.out.println("Do work in ComplexFun impl...");
			}
			
		});
	}

	public static void carryOutWork(SimpleFuncInterface sfi) {
		sfi.doWork();
	}

	public static void carryOutWork(ComplexFunctionalInterface cfi) {
		cfi.doWork();
		cfi.doSomeWork();
		cfi.doSomeOtherWork();
	}
}
