package com.ty;

import java.util.Scanner;

public class AccountBalanceException extends RuntimeException {
	String message;

	public AccountBalanceException(String message) {
		super();
		this.message = message;
	}
	@Override
public String getMessage() {
		return message;
}

	public static void main(String[] args) {
		System.out.println("Welcome to Bank Of Baroda !!");
		double balance=15000;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Amount to be withdrawn less than or equal to "+balance);
		double amt=sc.nextDouble();
		sc.close();
		if(amt<=balance) {
			System.out.println("Withdrawal Sucessfull");
		}
		else {
			try {
			throw new AccountBalanceException("Insufficient Balance");
		}
			catch (RuntimeException  e) {
				System.out.println(e.getMessage());
			}
		finally {
			System.out.println("Thank you visit again...");
		}
		}
	}

}