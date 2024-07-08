package com.java;

import java.util.Scanner;

public class ProgarmJava1 {

	public static void main(String[] args) {
     
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter n value");
		int n=sc.nextInt();
		 if(n %2==0) {
			 System.out.println("Even");
		 }
		 else if(!(n % 2==0)){
			 System.out.println("odd");
		 }
		 else {
			 System.out.println("Ïnvalid");
			 
		 }
		  

	}

}
