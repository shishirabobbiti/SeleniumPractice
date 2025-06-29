package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJava1 {

	public static void main(String[] args) {
	      int[] arr= {3,4,7,8,9,10,11,23,24,2526,90};
	      
	      for(int i=0;i<arr.length;i++)
	      {
	    	  if(arr[i] % 2==0) {
	    		  System.out.println(arr[i] +" Multiple of 2");
	    		 // break;
	    		 //break it will stop the loop ,once will get the one result atleast
	    	  }
	    	  else {
	    		  System.out.println("Not Multiple of 2");
	    	  }
	      }
	      ArrayList<String> a= new  ArrayList<String>();
	      //accessing array list=object.method
	      
	      a.add("Shishira");
	      a.add("Heshika");
	      a.add("Ghee");
	     // a.remove(2);
	      System.out.println(a.get(1));
	      //Index 2 out of bounds for length 2
	     // System.out.println(a.get(2));
   
	      for(int i=0;i<a.size();i++) {
	    	  System.out.println(a.get(i));
	      }
	      System.out.println("****Enhanced forloop*****");
	      //Enhanced forloop
	      for(String val:a){
	    	  System.out.println(val);
	    	  
	      }
	      //items present in ArrayList
	      System.out.println(a.contains("Ghee"));
	      String[] names= {"Shishira","Mike","Maruthi"};
	      //Convert traditional array to arraylist
	      List<String>namesarraylist=Arrays.asList(names);
	      System.out.println(namesarraylist.contains("Mike"));
	      System.out.println(namesarraylist);
	}

}
