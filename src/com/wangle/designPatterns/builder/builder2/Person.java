package com.wangle.designPatterns.builder.builder2;

public class Person {
	private int id;
	private String sex;
	private int age;
	private String location;
	private int weight;
	private int height;
	private int score;
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", sex=" + sex + ", age=" + age + ", location=" + location + ", weight=" + weight
				+ ", height=" + height + ", score=" + score + "]";
	}

	private Person(){
		
	}
	
	static class PersonBuilder{
		Person p = new Person();
		
		public PersonBuilder builderPart1(int id,String sex,int age){
			p.id = id;
			p.sex = sex;
			p.age = age;
			return this;
		}
		
		public PersonBuilder builderPart2(String location,int weight,int height){
			p.location = location;
			p.weight = weight;
			p.height = height;
			return this;
		}
		
		public PersonBuilder builderPart3(int score){
			p.score = score;
			return this;
		}
		
		public Person end(){
			return p;
		}
	}
}
