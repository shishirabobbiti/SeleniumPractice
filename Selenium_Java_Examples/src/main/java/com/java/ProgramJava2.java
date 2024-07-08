package com.java;

import java.util.Scanner;

public class ProgramJava2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter n value");
		int n=sc.nextInt();
		if(!(n % 2==0))
				{
			System.out.println("print weird");
				}
		else if((n % 2 ==0 )&& (!(n<2)) && (n<=5)) {
			System.out.println("print not weird");
		}
		else if((n % 2 ==0 )&& (!(n<6)) && (n<=20)) {
			System.out.println("print weird");
		}
			
		else if((n % 2 ==0 )&& (n>20)) {
			System.out.println("print not weird");
		}
	}

}
