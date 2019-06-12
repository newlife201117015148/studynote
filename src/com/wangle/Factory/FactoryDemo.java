package com.wangle.Factory;

public class FactoryDemo {
	public static void main(String[] args) {
		Person p1 = Factory.getInstance("student","Íõ³¬",23,99.0);
		System.out.println(p1.toString());
		Person p2 = Factory.getInstance("worker","½¯Àö¾ý",34,2233.4);
		if(p2!=null){
			System.out.println(p2.toString());
		}
	
	}
}
