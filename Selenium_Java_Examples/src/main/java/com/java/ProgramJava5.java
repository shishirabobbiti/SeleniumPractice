package com.java;

import java.util.Scanner;

public class ProgramJava5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many cups Bought");
		int n = sc.nextInt();
		if (n >= 1) {
			int x = n / 6;
			if(x==0) {
				System.out.println("No free cups");
				System.out.println("your total cups are :: " + (x+n));
			}
			else {
				System.out.println("Total free cups you got ::" +x );
			System.out.println("your total cups are :: " + (n+x));
			}
		} else {
			System.out.println("Invalid cups");
		}
	}

}
