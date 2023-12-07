package com.camera;

public class Camera {
  
	private int id;
	private String brand;
	private String model;
	private float price;
	private boolean status;
	static int count = 1;
	static boolean flag=true;
	
	public Camera(String brand, String model, float price) {
		
		this.id = count;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.status = flag;
		count++;
	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Camera.count = count;
	}

	public String stauts(boolean flag) {
		if(flag)
		return "Available";
		else 
			return "Rented";
		
	}
		
}
