package com.ty;

interface DiamondProblem {
	void display();
}

interface test extends DiamondProblem {

}

class Main implements DiamondProblem, test {
	@Override
	public void display() {
		System.out.println("Hi Hello Welcome to India !!");

	}

	public static void main(String[] args) {
		Main m = new Main();
		m.display();
	}
}