package com.wangle.designPatterns.builder.builder2;

public class Main {
	//需要哪些字段的person对象，就调用哪些build方法
	public static void main(String[] args) {
		Person p = new Person.PersonBuilder()//静态内部类的创建方法
						.builderPart1(1231, "boy", 12)
						.builderPart2("四川", 50, 120)
						.builderPart3(99)
						.end();
		
		System.out.println(p);
	}
}
