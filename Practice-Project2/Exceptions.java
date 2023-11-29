package com.ty;

public class Exceptions{
public static void main(String[] args) {
	try{
		System.out.println(10/0);
	}
	catch (Exception e) {
		System.out.println("Number cannot be divided by zero");
	}
}
}
