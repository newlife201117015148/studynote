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
	//����ʽ   ȱ�㣺 �����������ʱ�������Ŷ����󣬴ﵽһ����������ʱ������Ӱ���ٶȡ�
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
		return "������"+name+"   "+"���䣺"+age+";";
	}
}
