package com.edu.abhi.fileio.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class AppendFileDemo {

	public static void main(String[] args) throws IOException {
		// Content to append.
		String contentToAppend = "\nThis line was added at the end of the file !" + " - " + new Date() ;
		appendToTextFile("FileToBeWrittenNIO", contentToAppend);
	}
	public static void appendToTextFile(String fileName, String contentToAppend) throws IOException {
		Files.write(Paths.get(fileName), contentToAppend.getBytes(), StandardOpenOption.APPEND);
	}
}
