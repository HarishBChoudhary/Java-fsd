package com.camera;

import java.util.Scanner;

public class Solution {
	
	public static void menu() {
		System.out.println("1. MY CAMERA\n2. RENT A CAMERA\n" + "3. VIEW ALL CAMERAS\n4. MY WALLET\n5. EXIT");
	}
	public static void main(String[] args) {

		String password = "admin";
		String usrid = "admin123";

		Scanner sc = new Scanner(System.in);

		WalletImp wal=new WalletImp();
		CameraRental cr = new CameraRentalImp();
		
		cr.cameras();

		System.out.println("+--------------------------------+");
		System.out.println("|  WELCOME TO CAMERA RENTAL APP  |");
		System.out.println("+--------------------------------+");
		System.out.print("PLEASE LOGIN TO CONTINUE - ");

		System.out.print("USERNAME - ");
		String pswd = sc.next().toLowerCase();
		System.out.print("PASSWORD - ");
		String uid = sc.next().toLowerCase();
		if (password.equals(pswd) && usrid.equals(uid)) {
			while (true) {
				menu();
				int ch = sc.nextInt();
				switch (ch) {
				case 1: {
					System.out.println("1. ADD\n2. REMOVE\n3. VIEW MY CAMERAS"
							+ "\n4. GO TO PREVIOUS MENU");
					int sh=sc.nextInt();
					switch(sh) {
					case 1:
						cr.addCamera();
						break;
					case 2:
						cr.removeCamera();
						break;
					case 3:
						cr.displayCamera();
						break;
					case 4:
						break;
					default:
						throw new IllegalArgumentException("PLEASE ENTER A VALID VALUE: " + ch);
					}
					break;
				}
				case 2:
					cr.rentCamera();
					break;
				case 3:
					cr.displayCamera();
					break;
				case 4:
					wal.myWallet();
					break;
				case 5:
					System.out.println("Thank You!!!");
					System.exit(0);
				default:
					throw new IllegalArgumentException("PLEASE ENTER A VALID VALUE: " + ch);
				}
			}
		} else {
			try {
				throw new InvalidUserIdAndPasswordException("PLEASE ENTER VALID USERID AND PASSWORD.");

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
