package com.wangle.designPatterns.strategy.strategy03;

public class Dog{
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
	
}
