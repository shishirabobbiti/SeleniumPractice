package com.java;

import java.util.Scanner;

public class ProgramJava10 {

	public static void main(String[] args) {
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int n = sc.nextInt();
		if (n < 0) {
			System.out.println("Invaid number");
		} else {
			for (int i = 0; i <= n; i++) {
				int x = n % 10; // it will print last value of any number
				if (x % 3 == 0) {
					System.out.println(x + " is divisible by 3");
					sum = sum + x;
				} else {
					System.out.println(x + " is  not divisible by 3");
				}
				n = n / 10;
			}

			// it will remove last value from number
			System.out.println("sum : " + sum);
		}

	}

}
