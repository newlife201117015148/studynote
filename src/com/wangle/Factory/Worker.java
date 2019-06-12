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
		return "工人的名字："+this.getName()+"---工人的年龄："+this.getAge()+"---工人的薪水："+this.getSalary()+";";
	}
	
	String say() {
		return this.toString();
	}
}
