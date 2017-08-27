package com.edu.abhi.question.codility;

public class HCFandLCM {

	public static void main(String[] args) {
		hcfLcm(6, 10);
		hcfLcm(10, 100);

	}

	private static void hcfLcm(int i, int j) {
		int a, b, t, hcf, lcm;
        a = i;
        b = j;
        while(b != 0){
            t = b;
            b = a%b;
            a = t;
        }
		
        hcf = a;
        lcm = (i*j)/hcf;
		
        System.out.println("HCF = " +hcf);
        System.out.println("LCM = " +lcm);

	}
}
