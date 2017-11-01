package com.edu.abhi.fileio;

import java.io.File;

public class DeleteRenameFileDemo {

	public static void main(String[] args) {

	}

	public static void renameFile(File OldFile, File newFile) {
		boolean flag = OldFile.renameTo(newFile);
		if (flag) {
			System.out.println("File renamed successfully");
		} else {
			System.out.println("Rename operation failed");
		}
	}

	public static void deleteFile(File file) {
		try {
			/*
			 * the delete() method returns true if the file is deleted
			 * successfully else it returns false
			 */
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete failed: File didn't delete");
			}
		} catch (Exception e) {
			System.out.println("Exception occurred");
			e.printStackTrace();
		}
	}
}
