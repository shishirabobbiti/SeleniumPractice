package com.java;

import java.util.Scanner;

public class ProgramJava12 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int n = sc.nextInt();
		while(n>0)
		{
			int x=n%10;
			System.out.print(x);
			n=n/10;
		}
	}

}
