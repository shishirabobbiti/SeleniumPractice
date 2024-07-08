package com.java;

import java.util.Scanner;

public class ProgramJava8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number value");
		int num = sc.nextInt();
       int sum=0;
		  while(num!=0){
			  int x=num %10;
				if(x%2==0) {
					sum=sum+x;
					System.out.println(x + " is Even");
				}
				num=num/10;
				}
			System.out.print(sum + "  is Sum of Even Numbers");
			
		}
		
	



	}


