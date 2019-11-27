package com.wangle.designPatterns.Factory.Factory02;

import com.wangle.designPatterns.Factory.Factory01.*;
public class PlaneFactory {
	private PlaneFactory(){}
	private static class InnerClass{
		private static final PlaneFactory instance = new PlaneFactory();
	}
	public static PlaneFactory getInstance(){
		return InnerClass.instance;
	}
	public Moveable create(){
		System.out.println("a plane is created!");
		return new Plane();
	}

}
