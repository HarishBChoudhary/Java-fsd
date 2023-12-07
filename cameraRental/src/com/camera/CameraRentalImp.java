package com.camera;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CameraRentalImp implements CameraRental {

	Scanner sc = new Scanner(System.in);

	WalletImp wal = new WalletImp();

	Map<Integer, Camera> db = new LinkedHashMap<Integer, Camera>();

	@Override
	public void addCamera() {
		System.out.print("ENTER THE CAMERA BRAND - ");
		String brand = sc.next();
		System.out.print("ENTER THE MODEL - ");
		String model = sc.next();
		System.out.print("ENTER THE PER DAY PRICE (INR) - ");
		float price = sc.nextFloat();
		Camera c = new Camera(brand, model, price);
		db.put(c.getId(), c);
		System.out.println("YOUR CAMERA HAS BEEN SUCESSFULLY ADDED TO THE LIST.");
	}

	@Override
	public void removeCamera() {
		displayCamera();
		System.out.println("ENTER THE CAMERA ID TO REMOVE - ");
		int id = sc.nextInt();
		if (db.containsKey(id)) {
			db.remove(id);
			System.out.println("CAMERA SUCESSFULLY REMOVED FROM THE LIST.");
		} else {
			try {
				throw new CameraNotFoundException("CAMERA WITH ID " + id + " IS NOT FOUND!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayCamera() {
		Set<Integer> key = db.keySet();
		System.out.println("=======================================================================");
		System.out.printf("%-12s%-12s%-12s%-18s%s%n", "CAMERA ID", "BRAND", "MODEL", "PRICE(PER DAY)", "STATUS");
		System.out.println("=======================================================================");

		for (Integer k : key) {
			Camera c = db.get(k);
			System.out.printf("%-12d%-12s%-12s%-18.1f%s%n", c.getId(), c.getBrand(), c.getModel(), c.getPrice(),
					c.stauts(c.getStatus()));
		}
		System.out.println("=======================================================================");
	}

	@Override
	public void displayAvailableCamera() {
		Set<Integer> key = db.keySet();

		System.out.println("=======================================================================");
		System.out.printf("%-12s%-12s%-12s%-18s%s%n", "CAMERA ID", "BRAND", "MODEL", "PRICE(PER DAY)", "STATUS");
		System.out.println("=======================================================================");

		for (Integer k : key) {
			Camera c = db.get(k);
			if (c.getStatus()==true) {
				System.out.printf("%-12d%-12s%-12s%-18.1f%s%n", c.getId(), c.getBrand(), c.getModel(), c.getPrice(),
						c.stauts(c.getStatus()));
			}
		}
		System.out.println("=======================================================================");
	}

	@Override
	public void rentCamera() {
		System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S) -");
		displayAvailableCamera();
		System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT - ");
		int id = sc.nextInt();
		Camera c = db.get(id);
		if ((db.containsKey(id)) && (c.getStatus() == true) && (wal.getBalance() >= c.getPrice())) {
			System.out.println("YOUR TRANSACTION FOR CAMERA - " + c.getBrand() + " " + c.getModel() + " with rent INR."
					+ c.getPrice() + " HAS SUCESSFULLY COMPLETED.");
			c.setStatus(false);
			float bal=wal.getBalance()-c.getPrice();
			wal.setBalance(bal);
		} else {

			try {
				throw new InsufficientWalletBalanceException(
						"ERROR: TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE. PLEASE DEPOSIT THE AMOUNT TO  YOUR WALLET");
			} catch (InsufficientWalletBalanceException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void cameras() {
		Camera cam = new Camera("Samsung", "DS123", 500);
		db.put(cam.getId(), cam);
		Camera cam1 = new Camera("Sony", "HD214", 500);
		db.put(cam1.getId(), cam1);
		Camera cam2 = new Camera("Panasonic", "XC", 500);
		db.put(cam2.getId(), cam2);
		Camera cam3 = new Camera("Canon", "XLR", 500);
		db.put(cam3.getId(), cam3);
		Camera cam4 = new Camera("Fujitsu", "J5", 500);
		db.put(cam4.getId(), cam4);
		Camera cam5 = new Camera("Sony", "HD226", 500);
		db.put(cam5.getId(), cam5);
		Camera cam6 = new Camera("Samsung", "DS246", 500);
		db.put(cam6.getId(), cam6);
		Camera cam7 = new Camera("LG", "L123", 500);
		db.put(cam7.getId(), cam7);
		Camera cam8 = new Camera("Canon", "XPL", 500);
		db.put(cam8.getId(), cam8);
		Camera cam9 = new Camera("Chroma", "CT", 500);
		db.put(cam9.getId(), cam9);
		Camera cam10 = new Camera("Canon", "Digital", 123);
		db.put(cam10.getId(), cam10);
		Camera cam11 = new Camera("Nikon", "DSLR-D7500", 500);
		db.put(cam11.getId(), cam11);
		Camera cam12 = new Camera("Sony", "DSLR12", 200);
		db.put(cam12.getId(), cam12);
		Camera cam13 = new Camera("SONY", "SONY1234", 123);
		db.put(cam13.getId(), cam13);
		Camera cam14 = new Camera("Canon", "5050", 25000);
		db.put(cam14.getId(), cam14);
		Camera cam15 = new Camera("nikon", "2030", 500);
		db.put(cam15.getId(), cam15);
		Camera cam16 = new Camera("Something", "something", 300);
		db.put(cam16.getId(), cam16);
		Camera cam17 = new Camera("Kodak", "Cntpl", 500);
		db.put(cam17.getId(), cam17);
		Camera cam18 = new Camera("Asus", "DSLR-XL30", 11500);
		db.put(cam18.getId(), cam18);
		Camera cam19 = new Camera("Chroma", "HDDL", 5000);
		db.put(cam19.getId(), cam19);
		Camera cam20 = new Camera("Canon", "UXPL", 15000);
		db.put(cam20.getId(), cam20);

	}

}