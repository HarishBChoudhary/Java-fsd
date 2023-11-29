package com.ty;

class Demo extends Thread {

	@Override
	public void run() {
		System.out.println("Thread gets Started");
	}

}

class Harish implements Runnable {

	@Override
	public void run() {
		System.out.println("Thred from runnable interface");
	}

}

class Runner {
	public static void main(String[] args) {
		Demo d1 = new Demo();
		d1.start();
		Harish h = new Harish();
		Thread t = new Thread(h);
		t.start();

	}
}