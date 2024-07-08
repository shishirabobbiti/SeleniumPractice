package com.java;

import java.util.Scanner;

public class ProgramJava4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter salecount");
		int salecount = sc.nextInt();
		if (salecount >= 30 && salecount <= 100) {

			if (salecount >= 30 && salecount <= 50) {
				System.out.println("D");
			}
			else if (salecount >= 51 && salecount <= 60) {
				System.out.println("C");
			}
			else if (salecount >= 61 && salecount <= 80) {
				System.out.println("B");
			}
			else 
				 {
				System.out.println("A");
			}
		} else {
			System.out.println("sale count is not correct");
		}
	}

}
