package com.java;

import java.util.Scanner;

public class ProgramJava9 {

	public static void main(String[] args) {
       
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int num = sc.nextInt();
       int sum=0;
		  while(num!=0){
			  int x=num %10;
				if(!(x%2==0)) {
					sum=sum+x;
					System.out.println(x + " is odd");
				}
				num=num/10;
				}
			System.out.print(sum + "  is Sum of odd Numbers");
		
		
	}

}
