package com.java;

public class MethodDemo {

	public static void main(String[] args) {
		//object should create for class  to access the methods
		MethodDemo d=new MethodDemo();
		d.getdata();
		String name=d.getdata1();
		System.out.println(name);
		getdata2();
		MethodDemo2 d1=new MethodDemo2();
		d1.getdata3();

	}
	
	public void getdata()
	{
		System.out.println("Hello World");
	}
	public String getdata1()
	{
		System.out.println("returing value");
		return "ShishraReddy";
	}
	
	//same class methods is not required to create the objects for class ,if we use below way
	public static void getdata2()
	{
		System.out.println("Sameclass Methods");
	}

}
