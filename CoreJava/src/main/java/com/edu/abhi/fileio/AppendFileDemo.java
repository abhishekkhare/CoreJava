package com.edu.abhi.fileio;

import java.io.*;
import java.util.Date;

public class AppendFileDemo {

	public static void main(String[] args) throws IOException {
		// Content to append.
		String contentToAppend = "\nThis line was added at the end of the file !" + " - " + new Date();
		File file = new File("FileToBeWritten");
		appendToTextFile(file, contentToAppend);
		appendToTextFileP(file);

	}

	/**
	 * Using FileWriter and BufferedWriter
	 * 
	 * @param file
	 * @param contentToAppend
	 * @throws IOException
	 */
	public static void appendToTextFile(File file, String contentToAppend) throws IOException {
		try {

			/*
			 * This logic is to create the file if the file is not already
			 * present
			 */
			if (!file.exists()) {
				file.createNewFile();
			}

			// Here true is to append the content to file
			FileWriter fw = new FileWriter(file, true);
			// BufferedWriter writer give better performance
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contentToAppend);
			// Closing BufferedWriter Stream
			bw.close();

			System.out.println("Data successfully appended at the end of file");

		} catch (IOException ioe) {
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}
	}

	/**
	 * Using PrintWriter
	 * @param file
	 * @throws IOException
	 */
	public static void appendToTextFileP(File file) throws IOException {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			// This will add a new line to the file content
			pw.println("");
			/*
			 * Below three statements would add three mentioned Strings to the
			 * file in new lines.
			 */
			pw.println("This is first line");
			pw.println("This is the second line");
			pw.println("This is third line");
			pw.close();

			System.out.println("Data successfully appended at the end of file");

		} catch (IOException ioe) {
			System.out.println("Exception occurred:");
			ioe.printStackTrace();
		}
	}
}
