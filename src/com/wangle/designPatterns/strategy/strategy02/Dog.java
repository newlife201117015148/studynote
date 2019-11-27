package com.wangle.designPatterns.strategy.strategy02;

public class Dog implements Comparable<Dog>{
	private int weight;
	private int height;
	public Dog(int weight,int height){
		// TODO Auto-generated constructor stub
		this.weight = weight;
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Dog [weight=" + weight + ", height=" + height + "]";
	}
	@Override
	public int compareto(Dog c) {
		return c.height>this.height?1:c.height==this.height?0:-1;
	}
	
}
