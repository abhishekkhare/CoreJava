package com.edu.abhi.nio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Writer {

	public static void main(String[] args) throws IOException {
		
		String str = "Hello World! \n";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 50000; j++) {
				sb.append(str + " -" +j);
			}
		}
		
		System.out.println("writeWithoutNIO::START");
		long start = System.currentTimeMillis();
		writeWithoutNIO(sb.toString());
		long end =System.currentTimeMillis();
		System.out.println("writeWithoutNIO::END::" + (end-start));
		

		System.out.println("writeWithNIO::START");
		start = System.currentTimeMillis();
		writeWithNIO(sb.toString());
		end =System.currentTimeMillis();
		System.out.println("writeWithNIO::END::" + (end-start));
		

	}
	
	private static void writeWithNIO(String str) throws IOException{
		Files.write(Paths.get("/Users/abhishekkhare/Documents/myGITWorkspace/CoreJava/CoreJava/src/main/java/com/edu/abhi/nio/withNio.txt"), str.getBytes(), StandardOpenOption.CREATE);
	
	}
	private static void writeWithoutNIO(String str) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/abhishekkhare/Documents/myGITWorkspace/CoreJava/CoreJava/src/main/java/com/edu/abhi/nio/withoutNio.txt"));
		writer.write(str);
	    writer.close();
	}

}
