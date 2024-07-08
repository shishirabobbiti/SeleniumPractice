package com.java;

import java.util.Scanner;

public class ProgramJava7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number value");
		int Num = sc.nextInt();
       int sum=0;
		  while(Num!=0){
			  sum=sum+Num%10;
				Num=Num/10;
				}
			System.out.print(sum);
		}
		
	}


