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
		return "ѧ�����֣�"+this.getName() +"--ѧ�����䣺"+this.getAge()+"--ѧ��������"+this.getScore()+"��";
	}
	String say() {
		
		return this.toString();
	}
}
