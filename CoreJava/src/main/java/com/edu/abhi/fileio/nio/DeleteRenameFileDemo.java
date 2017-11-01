package com.edu.abhi.fileio.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DeleteRenameFileDemo {

	public static void main(String[] args) {

	}

	public static void renameFile(String OldFileName, String newFileName) {
		Path sourcePath = Paths.get(OldFileName);
		Path destinationPath = Paths.get(newFileName);

		try {
			Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteFile(String fileName) {
		try {
			Path path = Paths.get(fileName);
			Files.delete(path);
		} catch (IOException e) {
			System.out.println("Exception occurred");
			e.printStackTrace();
		}
	}
}
