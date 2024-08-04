package com.java;

import java.util.Scanner;

public class ProgramJava13 {
	static char firstnum;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		String str=sc.nextLine();
		System.out.println(str);
		int count=0;
		
		for(int i=0;i<str.length();i++) {
			
			char d=str.charAt(i);
			if(d=='0') {
				count++;
	
			}
			firstnum=str.charAt(0);
		}
		
			if(count>0 && firstnum!='0') {
				System.out.println("it is  duck number");
			}
			else {
				System.out.println("it is not duck number");
			}
		}
	}
	


	
		
	

