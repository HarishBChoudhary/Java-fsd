package com.ty;

public class ExceptionHandelling {
public static void main(String[] args) {
	int[] a= {10,2,3,4,5,6};
	for (int i = 0; i <=a.length; i++) {
		try{
			System.out.println(a[i]);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
}
