package com.wangle.dynamicProxy;

public class Test6 {
	public static void main(String[] args) {
		Company sa = new Company();
		
		sa.setObj(new Bird());
		
		Flyable bird = (Flyable) sa.getInstance();
		System.out.println(bird.getClass().getName());
		bird.fly();
		
		System.out.println("---------------------------");
		Company sa2 = new Company();
		sa2.setObj(new Airplane());//增加被代理对象，
		
		Flyable airplane = (Flyable)sa2.getInstance();
		System.out.println(airplane.getClass().getName());
		airplane.fly();
		System.out.println("---------------------------");
		Company sa3 = new Company();
		sa3.setObj(new Rabbit());//支持不同的被代理类和不同的接口
		
		Runable rabbit = (Runable)sa3.getInstance();
		System.out.println(rabbit.getClass().getName());
		rabbit.run();
		
		System.out.println("---------------------------");
		
		CompanyB b = new CompanyB();//增加代理方案，并支持多重代理
		b.setObj(bird);
		Flyable airplanes = (Flyable)b.getInstance();
		System.out.println(airplanes.getClass().getName());
		airplanes.fly();
		
	}
}
