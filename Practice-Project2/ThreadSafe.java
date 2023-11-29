package com.ty;

class Netflix {
	synchronized void watch(String name) {
		System.out.println(name+" is watching movie");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+" done with watching movie\n------------------------------------------");
		System.out.println("------------------------------------------");
	}
}

public class ThreadSafe  extends Thread{
	String name;
	Netflix n;

	public ThreadSafe(String name, Netflix n) {
		super();
		this.name = name;
		this.n = n;
	}
	@Override
	public void run() {
		n.watch(name);
	}
	public static void main(String[] args) {
		Netflix n=new Netflix();
		ThreadSafe p1=new ThreadSafe("Harish", n);
		ThreadSafe p2=new ThreadSafe("raju", n);
		p1.start();
		p2.start();
	}
}
