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

		// Very Important, the Lambda Expression always chooses the
		// subclass which is lowest in the hierarchy for execution. If we remove
		// the method with
		// "VeryComplexFunctionalInterface" argument it will pick the
		// method with "ComplexFunctionalInterface" argument and not the one
		// with SimpleFuncInterface.

		carryOutWork(() -> System.out.println("Do work in lambda exp impl..."));

		System.out.println("*******************************");
		carryOutWork(new ComplexFunctionalInterface() {
			@Override
			public void doWork() {
				System.out.println("Do work in ComplexFun impl...");
			}

		});
	}

	public static void carryOutWork(SimpleFuncInterface sfi) {
		System.out.println("SIMPLE");
		sfi.doWork();
	}

	public static void carryOutWork(ComplexFunctionalInterface cfi) {
		System.out.println("COMPLEX");
		cfi.doWork();
		cfi.doSomeWork();
		cfi.doSomeOtherWork();
	}

	public static void carryOutWork(VeryComplexFunctionalInterface cfi) {
		System.out.println("VERY COMPLEX");
		cfi.doWork();
		cfi.doSomeWork();
		cfi.doSomeOtherWork();
		cfi.doSomeVeryComplexWork();
	}
}
