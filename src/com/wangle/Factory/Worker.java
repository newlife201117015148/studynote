package com.wangle.Factory;

public class Worker extends Person{
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Worker(){}
	public Worker(String name,int age,double salary){
		super(name,age);
		this.salary = salary;
	}
	
	public String toString(){
		return "���˵����֣�"+this.getName()+"---���˵����䣺"+this.getAge()+"---���˵�нˮ��"+this.getSalary()+";";
	}
	
	String say() {
		return this.toString();
	}
}
