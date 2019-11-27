package com.wangle.designPatterns.Factory.Factory03;

public class MagicFactory extends AbstractFactory{

	@Override
	Food createFood() {
		// TODO Auto-generated method stub
		return new Mushroom();
	}

	@Override
	Vehicle createVehicle() {
		// TODO Auto-generated method stub
		return new Broom();
	}

	@Override
	Weapoon createWeapoon() {
		// TODO Auto-generated method stub
		return new MagicStick();
	}

}
