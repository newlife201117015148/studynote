package com.wangle.javaIO;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 5278854905636593056L;
	static String a = "你能看到我吗";
	
	private String name ;
	private String sex;
	private int age;
	private transient float score;
	private IDCard card;
	
	
	public Student(String name,String sex,int age,float score){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.score = score;
		
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void countStar() throws InterruptedException{
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			Thread.sleep(2000);
		}
	}
	public IDCard getCard() {
		return card;
	}
	public void setCard(IDCard card) {
		this.card = card;
	}
}
