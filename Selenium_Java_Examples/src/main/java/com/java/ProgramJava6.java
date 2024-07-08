package com.java;

import java.util.Scanner;

public class ProgramJava6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value");
		int n = sc.nextInt();
        System.out.println(n);
        if(n>0) {
        	System.out.println("correct value");
        	for(int i=0;i<=n;i++) {
        	int  x=n%10;  //it will print last value of any number
        	System.out.print(x + " ");
        	n=n/10; //it will remove last value from number
        	}
        }
        
        else {
        	System.out.println("Give correct value");
        }

	}
}