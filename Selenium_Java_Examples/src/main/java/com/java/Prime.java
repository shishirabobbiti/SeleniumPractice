package com.java;
import java.util.Scanner;
public class Prime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int num = sc.nextInt();
		int i, track = 0;
		if(num>1) {
		for(i=2;i<num;i++)
		{
			if (num % i == 0) {
				track = 1;
			}
			}
		
		if (track == 0) {
			System.out.println(num + " prime number");
		} else {
			System.out.println(num + "  Not a Prime Number");
		}
	}
		else
			System.out.println("invalid number");
}
}
