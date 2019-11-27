package com.wangle.others;

public class Student2 {
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
	//饱汉式   缺点： 请求数量大的时候会出现排队现象，达到一定数量级的时候严重影响速度。
	private Student2(){
		
		System.out.println("sssss");
	}
	
	private static Student2 stu =null;
	
	public static synchronized Student2 getStudent()
	{
		if(stu==null){
			stu = new Student2();
		}
		return stu;
	}
	@Override
	public String toString() {
		return "姓名："+name+"   "+"年龄："+age+";";
	}
}
