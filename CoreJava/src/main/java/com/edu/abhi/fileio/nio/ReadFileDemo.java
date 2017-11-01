package com.edu.abhi.fileio.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileDemo {

	public static void main(String[] args) throws IOException {
		// Specify the path of the file here
		String fileName = "FileToBeRead.txt";
		System.out.println(readTextFile(fileName));
		System.out.println("*********************************************************************");
		readTextFileByLines(fileName).stream().forEach(System.out::println);
	}
	
	public static String readTextFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return content;
    }

    public static List<String> readTextFileByLines(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        return lines;
    }

}
