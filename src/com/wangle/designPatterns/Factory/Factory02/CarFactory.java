package com.wangle.designPatterns.Factory.Factory02;

import com.wangle.designPatterns.Factory.Factory01.*;
public class CarFactory {
	private CarFactory(){}
	private static class InnerClass{
		private static final CarFactory instance = new CarFactory();
	}
	public static CarFactory getInstance(){
		return InnerClass.instance;
	}
	public Moveable create(){
		System.out.println("new car");
		return new Car();
	}

}
