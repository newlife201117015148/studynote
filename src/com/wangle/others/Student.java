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
	//��ʽ    ȱ�㣺����ص�ʱ���new��������ǰ����ռ䣬����Ҳ��ռ�ÿռ䣬�˷���Դ
	private Student() {
		System.out.println("sssss");
	};

	private static Student stu = new Student();

	public static Student getStudent() {
		return stu;
	}
	@Override
	public String toString() {
		return "������"+name+"   "+"���䣺"+age+";";
	}
}
