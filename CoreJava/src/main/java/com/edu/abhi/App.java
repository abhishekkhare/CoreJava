package com.edu.abhi;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {
	private static Map<String,String> map = new HashMap<String,String>();
	public static void main(String[] args) {
		
		encrypt("Abhishek1234@876_ =+");
		decrypt("Ysjufjne1234@876_ =+");

	}
	public static void decrypt(String text) {
		populateTheMap();
		String dencrypted="";
		for (int i = 0; i <text.length(); i++) {
			char temp  = text.charAt(i);
			String value = null;
			for (Entry<String, String> entry : map.entrySet()) {
		        if (Objects.equals(temp+"", entry.getValue())) {
		            value =  entry.getKey();
		        }
		    }
			if(value!=null){
				dencrypted+=value;
			}else{
				dencrypted+=temp;
			}
		}
		System.out.println(dencrypted);
		
	}
	public static void encrypt(String text) {
		populateTheMap();
		String encrypted="";
		for (int i = 0; i <text.length(); i++) {
			char temp  = text.charAt(i);
			//encrypted+=map.get(temp);
			String value =  map.get(temp+"");
			if(value!=null){
				encrypted+=value;
			}else{
				encrypted+=temp;
			}
		}
		System.out.println(encrypted);
		
		
	}
	private static void populateTheMap() {
		map.put("a", "i");
		map.put("b", "s");
		map.put("c", "h");
		map.put("d", "a");
		map.put("e", "n");
		map.put("f", "v");
		map.put("g", "r");
		map.put("h", "j");
		map.put("i", "u");
		map.put("j", "k");
		map.put("k", "e");
		map.put("l", "o");
		map.put("m", "p");
		map.put("n", "l");
		map.put("o", "z");
		map.put("p", "d");
		map.put("q", "b");
		map.put("r", "c");
		map.put("s", "f");
		map.put("t", "g");
		map.put("u", "m");
		map.put("v", "q");
		map.put("w", "t");
		map.put("x", "w");
		map.put("y", "x");
		map.put("z", "y");
		/******************/
		map.put("A", "Y");
		map.put("B", "X");
		map.put("C", "W");
		map.put("D", "T");
		map.put("E", "Q");
		map.put("F", "M");
		map.put("G", "G");
		map.put("H", "F");
		map.put("I", "C");
		map.put("J", "B");
		map.put("K", "D");
		map.put("L", "Z");
		map.put("M", "L");
		map.put("N", "P");
		map.put("O", "O");
		map.put("P", "E");
		map.put("Q", "K");
		map.put("R", "U");
		map.put("S", "J");
		map.put("T", "R");
		map.put("U", "V");
		map.put("V", "N");
		map.put("W", "A");
		map.put("X", "H");
		map.put("Y", "S");
		map.put("Z", "I");
		
		Set<String> keys = map.keySet();
		for (String string : keys) {
			System.out.println(string);
		}
	}
}
