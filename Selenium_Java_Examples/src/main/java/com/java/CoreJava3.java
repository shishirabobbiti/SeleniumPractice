package com.java;

public class CoreJava3 {

	public static void main(String[] args) {
		 
		//String is an object //String Literal
		String s="Shishira Reddy";
		//new
		String s1=new String("Welcome");
		
		System.out.println(s);
		//Split the string using delimiter
	String[] splittedString=s.split(" ");
	System.out.println(splittedString[0]);
	System.out.println(splittedString[1]);
	//Trim
	System.out.println(splittedString[0].trim());
	//to print the string into char's
	for(int i=0;i<s.length();i++)
	{
		System.out.println(s.charAt(i));  
	}
	//revese the string
	for(int i=s.length()-1;i>=0;i--)
	{
		System.out.println(s.charAt(i));
	}
		
		
	}

}
