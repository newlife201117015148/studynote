package com.wangle.designPatterns.strategy.strategy01;

public class Cat implements Comparable{

	private int weight;
	private int height;
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
	
	public Cat(int weight,int height) {
		// TODO Auto-generated constructor stub
		this.weight = weight;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Cat [weight=" + weight + ", height=" + height + "]";
	}
	@Override
	public int compareto(Comparable o) {
		Cat c = (Cat) o;
		
		return c.height>this.height?1:c.height==this.height?0:-1;
	}
	
	

}
