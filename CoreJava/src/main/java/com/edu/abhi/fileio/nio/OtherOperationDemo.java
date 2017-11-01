package com.edu.abhi.fileio.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class OtherOperationDemo {

	public static void main(String[] args) {
		Path path = Paths.get("newNIODir/FileToBeRead.txt");
		FileVisitor<Path> visitor = new MySimpleDeleteFileVisitor();
		try {
			deleteFileOrDir(path, visitor);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		path = Paths.get("newNIODir");
		try {
			deleteFileOrDir(path, visitor);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("*********************************************************");
		String fileName = "TestNIOFile.txt";
		String existingFileName = "FileToBeRead.txt";
		System.out.println(checkIfFileExists(fileName));
		System.out.println("Exists::" + checkIfFileExists(existingFileName));
		System.out.println("*********************************************************");
		String dirName = "newNIODir";
		createADirectory(dirName);
		System.out.println("Directory Created::" + checkIfFileExists(dirName));
		System.out.println("*********************************************************");
		copyAFile(existingFileName, dirName + File.separator + existingFileName);
		System.out.println("File Copied::" + checkIfFileExists(dirName + File.separator + existingFileName));
		System.out.println("*********************************************************");
		overrideAnExistingFile(existingFileName, dirName + File.separator + existingFileName);
		System.out.println("Override Success::" + checkIfFileExists(dirName + File.separator + existingFileName));
		System.out.println("*********************************************************");
		path = Paths.get("src");
		visitor = new MyFileVisitor();
		try {
			walkFileTree(path, visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("*********************************************************");
		visitor = new MySimpleSearchFileVisitor();
		try {
			searchingForFile(path, visitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkIfFileExists(String fileName) {
		Path path = Paths.get(fileName);
		return Files.exists(path, new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
	}

	public static void createADirectory(String fileName) {
		Path path = Paths.get(fileName);

		try {
			Path newDir = Files.createDirectory(path);
			System.out.println(newDir.toString());
		} catch (FileAlreadyExistsException e) {
			// the directory already exists.
		} catch (IOException e) {
			// something else went wrong
			e.printStackTrace();
		}
	}

	public static void copyAFile(String srcFileName, String destFileName) {
		Path sourcePath = Paths.get(srcFileName);
		Path destinationPath = Paths.get(destFileName);

		try {
			Files.copy(sourcePath, destinationPath);
		} catch (FileAlreadyExistsException e) {
			// destination file already exists
		} catch (IOException e) {
			// something else went wrong
			e.printStackTrace();
		}
	}

	public static void overrideAnExistingFile(String srcFileName, String destFileName) {
		Path sourcePath = Paths.get(srcFileName);
		Path destinationPath = Paths.get(destFileName);

		try {
			Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (FileAlreadyExistsException e) {
			// destination file already exists
		} catch (IOException e) {
			// something else went wrong
			e.printStackTrace();
		}
	}

	public static void walkFileTree(Path path, FileVisitor<Path> visitor) throws IOException {
		Files.walkFileTree(path, visitor);
	}

	public static void searchingForFile(Path path, FileVisitor<Path> visitor) throws IOException {
		Files.walkFileTree(path, visitor);
	}
	
	public static void deleteFileOrDir(Path path, FileVisitor<Path> visitor) throws IOException {
		Files.walkFileTree(path, visitor);
	}

}

class MyFileVisitor implements FileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("pre visit dir:" + dir);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("visit file: " + file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.out.println("visit file failed: " + file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		System.out.println("post visit directory: " + dir);
		return FileVisitResult.CONTINUE;
	}

}

class MySimpleSearchFileVisitor extends SimpleFileVisitor<Path> {
	String fileToFind = File.separator + "ArrayBlockingQueueExample.java";

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		String fileString = file.toAbsolutePath().toString();
		if (fileString.endsWith(fileToFind)) {
			System.out.println("file found at path: " + file.toAbsolutePath());
			return FileVisitResult.TERMINATE;
		}
		return FileVisitResult.CONTINUE;
	}

}

class MySimpleDeleteFileVisitor extends SimpleFileVisitor<Path> {
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("delete file: " + file.toString());
		Files.delete(file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		Files.delete(dir);
		System.out.println("delete dir: " + dir.toString());
		return FileVisitResult.CONTINUE;
	}
}