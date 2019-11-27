package com.wangle.designPatterns.Factory.Factory01;

public class Main {
	public static void main(String[] args) {
		SimpleVehicleFactory factory = new SimpleVehicleFactory();
		Moveable c = factory.createCar();
		c.go();
	}
}
