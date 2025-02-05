package com.java;

public class CoreJava {

	public static void main(String[] args) {
      int num=3;
      String name="Shishira Reddÿ";
      char letter='B';
      double dec=8.61;
      Boolean mycard=true;
      System.out.println(num +" ïs the vaue stored in num variable");
      System.out.println(name);
    		  //Arrays
      int[] arr= new int[5];
      arr[0]=1;
      arr[1]=3;
      arr[2]=4;
      arr[3]=5;
      arr[4]=6;
      //Anotherway
    		  
      int[] arr2= {3,4,7,8,9,10,11,23,24,2526,90};
      System.out.println(arr[1]);
      System.out.println(arr2[4]);
      
      //For loops
      //arr.length-5
      System.out.println();
      for(int i=0;i<arr.length;i++)
      {
    	  System.out.print(arr[i]);
      }
      System.out.println();
      for(int i=0;i<arr2.length;i++)
      {
    	  System.out.print(arr2[i]);
    	  
      }
      System.out.println();
      for(int ele :arr2) {
    	  System.out.print(ele);
    	  
      }
      System.out.println();
      String[] names= {"Shishira","Mike","Maruthi"};
      for(int i=0;i<names.length;i++)
      {
    	  System.out.println(names[i]);
      }
      
      for(String s:names)
      {
    	  System.out.println(s +" Enhanced for loop results");
      }
    	  
	}

}
