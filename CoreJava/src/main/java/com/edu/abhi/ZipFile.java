package com.edu.abhi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFile {

	public static void main(String[] args) throws IOException {
		//File newFile = new File("/Users/abhishekkhare/Downloads/Create_Project/Archive 2.zip");
		//File newFile = new File("/Users/abhishekkhare/Downloads/Create_Project/Archive.zip");
		//File newFile = new File("/Users/abhishekkhare/Downloads/Create_Project/Create_Project.zip");
//		File newFile = new File("/Users/abhishekkhare/Downloads/Create_Project/Others.zip");
//		List<String> list = getZipFileList(newFile);
//		for (String string : list) {
//			System.out.println(string);
//		}

		String text = "/work/AppleUniversity/Projects/255960_test33/Source-English (US)/test1.txt";
		int index = text.indexOf("/Source-English (US)/");
		System.out.println(text.substring(index+"/Source-English (US)/".length(), text.length()));
	}

	private static List<String> getZipFileList(File file) throws IOException {
		System.out.println(file.getParent());
		List<String> list = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		ZipInputStream zis = new ZipInputStream(fis);
		ZipEntry ze = zis.getNextEntry();
		while (ze != null) {
			String fileName = ze.getName();
			if(!validateFileName(fileName)){
				ze = zis.getNextEntry();
				continue;
			}
			list.add(fileName);
			zis.closeEntry();
			ze = zis.getNextEntry();
		}
		zis.closeEntry();
		zis.close();
		return list;
	}
	
	private static boolean validateFileName(String fileName) {
		if (fileName.indexOf("DS_Store") != -1) {
			return false;
		} else if (fileName.indexOf("__MACOSX") != -1) {
			return false;
		} else if (fileName.startsWith(".")) {
			return false;
		}
		return true;
	}
}
