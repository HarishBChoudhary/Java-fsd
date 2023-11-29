
package com.ty;

interface Vechile{
	void move();
}
class Car implements Vechile{
	public void move() {
		System.out.println("Car is Moving");
	}
}
class Bike implements Vechile{
	public void move(){
		System.out.println("Bike is Moving");
	}
}

class OOPs {
void prop(Vechile v) {
	v.move();
}
}
public class Solid{
	public static void main(String[] args) {
		Vechile car=new Car();
		Vechile bk=new Bike();
		OOPs op=new OOPs();
		op.prop(bk);
		op.prop(car);
	}
}