package com.ty;

public class Test extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <= 9; i++) {
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
public static void main (String[] args) {
	
	Test t=new Test();
	t.setName("Harish");
	System.out.println("Created a thread "+t.getName());
	t.start();
	
}
}
