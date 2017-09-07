package com.edu.abhi.designpatterns.proxy;

public class ProxyPatternTest {

	public static void main(String[] args) {
		//CommandExecutor executor = new CommandExecutorProxy("Abhishek", "wrong_pwd");
		CommandExecutor executor = new CommandExecutorProxy("Abhishek", "ABcd@123");
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}

	}

}
