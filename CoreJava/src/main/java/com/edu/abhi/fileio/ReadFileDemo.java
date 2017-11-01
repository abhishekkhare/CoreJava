package com.edu.abhi.fileio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("FileToBeRead.txt");
		System.out.println(readTextFile(file));
		System.out.println("*********************************************************************");
		readTextFileByLines(file).stream().forEach(System.out::println);
	}

	public static String readTextFile(File file) {
		// Specify the path of the file here

		BufferedInputStream bis = null;
		FileInputStream fis = null;
		StringBuffer sb = new StringBuffer();
		try {
			// FileInputStream to read the file
			fis = new FileInputStream(file);

			/*
			 * Passed the FileInputStream to BufferedInputStream For Fast read
			 * using the buffer array.
			 */
			bis = new BufferedInputStream(fis);

			/*
			 * available() method of BufferedInputStream returns 0 when there
			 * are no more bytes present in the file to be read
			 */
			while (bis.available() > 0) {
				sb.append((char) bis.read());
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("The specified file not found" + fnfe);
		} catch (IOException ioe) {
			System.out.println("I/O Exception: " + ioe);
		} finally {
			try {
				if (bis != null && fis != null) {
					fis.close();
					bis.close();
				}
			} catch (IOException ioe) {
				System.out.println("Error in InputStream close(): " + ioe);
			}
		}
		return sb.toString();

	}

	public static List<String> readTextFileByLines(File file) throws IOException {
		List<String> returnList = new ArrayList<String>();
		BufferedReader br = null;
		BufferedReader br2 = null;
		try {
			br = new BufferedReader(new FileReader(file));

			// One way of reading the file
			System.out.println("Reading the file using readLine() method:");
			String contentLine = br.readLine();
			while (contentLine != null) {
				returnList.add(contentLine);
				contentLine = br.readLine();
			}

			br2 = new BufferedReader(new FileReader(file));

			// Second way of reading the file
			System.out.println("Reading the file using read() method:");
			int num = 0;
			char ch;
			while ((num = br2.read()) != -1) {
				ch = (char) num;
				System.out.print(ch);
			}
			System.out.println();
			System.out.println("###############################################################################");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (br2 != null)
					br2.close();
			} catch (IOException ioe) {
				System.out.println("Error in closing the BufferedReader");
			}
		}
		return returnList;
	}

}
