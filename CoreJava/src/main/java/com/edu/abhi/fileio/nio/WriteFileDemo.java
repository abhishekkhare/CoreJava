package com.edu.abhi.fileio.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteFileDemo {
	public static void main(String[] args) throws IOException {
		String content = "This is my Data which needs" + " to be written into the file";
		writeToTextFile("FileToBeWrittenNIO", content);
	}

	public static void writeToTextFile(String fileName, String content) throws IOException {
		Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE);
	}
}
