package com.wangle.designPatterns.Factory.Factory01;
//交通工具的简单工厂
public class SimpleVehicleFactory {
//任何能产生对象的方法或者类，都可以称之为工厂。单例也是一种工厂。
	
	//简单工厂的一个弊端，就是扩展性不好，因为一要加一个类，你就必须添加一个createXXX()方法
	public Car createCar(){
		//可以在new的时候做一些动作，比如加日志
		System.out.println("car 被创建了");
		return new Car();
	}
	public Plane createPlane(){
		return new Plane();
	}
	public Broom createBroom(){
		return new Broom();
	}
}
