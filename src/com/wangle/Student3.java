package com.wangle;

public class Student3 {
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
	private Student3(){
		System.out.println("sssss");
	}
	
	private static Student3 stu = null;
	
	public static Student3 getStudent(){
		if(stu==null){
			synchronized (Student3.class) {
				if(stu==null){
					stu = new Student3();
				}
			}
		}
		return stu;
	}
	@Override
	public String toString() {
		return "ĞÕÃû£º"+name+"   "+"ÄêÁä£º"+age+";";
	}
}
