package com.java;

import java.util.Scanner;

public class ProgramJava3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter year");
		int n = sc.nextInt();
		if (n > 0) {
			  if((n % 100==0)&& ((n % 400==0)&& (n % 4==0))|| !(n %100==0) && (n % 4==0)) {
				  System.out.println("True");
			  }
			  else {
				  System.out.println("False");
			  }
			}
		
      
		else {
			System.out.println("Please enter a correct value");
		}

	}
}
