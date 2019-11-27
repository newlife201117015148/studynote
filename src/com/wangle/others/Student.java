package com.wangle.others;

public class Student {
	private int age;
	private String name;
	
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//恶汉式    缺点：类加载的时候就new出对象，提前分配空间，不用也会占用空间，浪费资源
	private Student() {
		System.out.println("sssss");
	};

	private static Student stu = new Student();

	public static Student getStudent() {
		return stu;
	}
	@Override
	public String toString() {
		return "姓名："+name+"   "+"年龄："+age+";";
	}
}
