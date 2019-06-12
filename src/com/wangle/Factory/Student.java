package com.wangle.Factory;

public class Student extends Person{
	private double score;
	
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	public Student(){}
	public Student(String name,int age,double score){
		super(name,age);
		this.score = score;
	}
	public String toString(){
		return "学生名字："+this.getName() +"--学生年龄："+this.getAge()+"--学生分数："+this.getScore()+"；";
	}
	String say() {
		
		return this.toString();
	}
}
