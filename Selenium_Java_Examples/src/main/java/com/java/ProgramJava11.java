package com.java;

import java.util.Scanner;

public class ProgramJava11 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int n = sc.nextInt();
		int count = 0;
		while (n > 0) {
            int x=n%10;
            count++;
			n = n / 10;
			

		}
		System.out.println(count++);
	}

}
