package com.java;

import java.util.Scanner;

public class ProgramJava9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int num = sc.nextInt();
		int i, sum = 0, track = 0;
		while (num > 0) {
			
				int n = num % 10;
				if(n==1) {
					System.out.println("Composite number");
					num = num / 10;
					continue;
				}
				track=0;
				for (int j = 2; j < n; j++) {

					if (n % j == 0) {
						track = 1;
						System.out.println(n +" Not a prime number");
						break;
					}

				}
				if (track == 0 && n!=0) {
					sum = sum + n;
					System.out.println(n +" is a prime number");
				}

				num = num / 10;

			

		}
		System.out.println(sum);
	}
}
