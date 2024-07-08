package com.java;

public class Assignment1 {

	public static void main(String[] args) {
	
		        //Create an Array
		        int[] numbers={22,33,44,55,66};
		       // Access and Print
		        System.out.println("firstelement: " +numbers[0]);
		        System.out.println("Last element: " +numbers[4]);
		        //Reverse Order
		        for(int i=numbers.length-1;i>=0;i--){
		            System.out.println(numbers[i]);
		        }
		        //Element Count
		        int totalelements=numbers.length;
		        System.out.println(totalelements);
		    
		}

		
	}

