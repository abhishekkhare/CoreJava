package com.edu.abhi.fileio.nio;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFileDemo {

	public static void main(String[] args) {
		Path path = null;
		try {
			path = Paths.get("newfileNIO.txt");
			Path newPath = Files.createFile(path);
			System.out.println(newPath.toString());
		} catch (FileAlreadyExistsException e) {
			System.out.println("File Already Exists ");
			try {
				Files.delete(path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		}

	}

}
