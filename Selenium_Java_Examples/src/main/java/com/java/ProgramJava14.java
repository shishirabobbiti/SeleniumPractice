package com.java;

import java.util.Scanner;

public class ProgramJava14 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int n = sc.nextInt();
		System.out.println("Enter d Number");

		int d = sc.nextInt();

		int count = 0;
		while (n > 0) {
			int x = n % 10;
			if (d == x) {
				count = count + 1;
			}
			n = n / 10;
		}
		System.out.println("number of occurrences of "
				+ d +" is " +count);

	}

}
