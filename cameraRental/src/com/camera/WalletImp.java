package com.camera;

import java.util.Scanner;

public class WalletImp implements Wallet {

	 float balance = 1000;
	 
	
		public float getBalance() {

			return balance;
		}


	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public void deposit(float amt) {
		System.out.print("YOUR WALLET UPDATED SUCESSFULLY. ");
		float bal=getBalance()+amt;
		setBalance(bal);
		//balance += amt;// balance=balance+amt;
		System.out.println("CURRENT WALLET BALANCE - INR." + getBalance());
	}


	@Override
	public void myWallet() {
		Scanner sc = new Scanner(System.in);
		System.out.println("YOUR CURRENT WALLET BALANCE IS - INR." + getBalance());
		System.out.println("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET?(1.YES 2.NO)");
		int ch = sc.nextInt();
		if (ch == 1) {
			System.out.print("ENTER THE AMOUNT (INR) - ");
			float amount = sc.nextFloat();
			deposit(amount);
		} else {
			System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S) -");
			CameraRentalImp c = new CameraRentalImp();
			c.displayAvailableCamera();
		}

	}

}
