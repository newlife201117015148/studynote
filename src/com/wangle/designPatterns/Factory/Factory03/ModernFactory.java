package com.wangle.designPatterns.Factory.Factory03;

public class ModernFactory extends AbstractFactory{

	@Override
	Food createFood() {
		// TODO Auto-generated method stub
		return new Bread();
	}

	@Override
	Vehicle createVehicle() {
		// TODO Auto-generated method stub
		return new Car();
	}

	@Override
	Weapoon createWeapoon() {
		// TODO Auto-generated method stub
		return new AK47();
	}

}
