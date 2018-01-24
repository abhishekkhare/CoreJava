package com.edu.abhi.fileio;

import java.io.*;

public class WriteFileDemo {
	public static void main(String[] args) throws IOException {
		String content = "This is my Data which needs" + " to be written into the file";
		File file = new File("FileToBeWritten");
		writeToTextFile(file, content);
		writeToTextFileB(file, content);
	}

	/**
	 * Using FileOutputStream
	 * 
	 * @param file
	 * @param content
	 * @throws IOException
	 */
	public static void writeToTextFile(File file, String content) throws IOException {
		FileOutputStream fos = null;
		try {
			// Specify the file path here
			fos = new FileOutputStream(file);

			/*
			 * This logic will check whether the file exists or not. If the file
			 * is not found at the specified location it would create a new file
			 */
			if (!file.exists()) {
				file.createNewFile();
			}

			/*
			 * String content cannot be directly written into a file. It needs
			 * to be converted into bytes
			 */
			byte[] bytesArray = content.getBytes();

			fos.write(bytesArray);
			fos.flush();
			System.out.println("File Written Successfully");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException ioe) {
				System.out.println("Error in closing the Stream");
			}
		}
	}

	/**
	 * Using BufferedWriter
	 * 
	 * @param file
	 * @param content
	 * @throws IOException
	 */
	public static void writeToTextFileB(File file, String content) throws IOException {
		BufferedWriter bw = null;
		try {
			/*
			 * This logic will make sure that the file gets created if it is not
			 * present at the specified location
			 */
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("File written Successfully");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}
	}

}
