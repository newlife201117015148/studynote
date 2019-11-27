package com.wangle.designPatterns.builder.builder1;

public class Main {
	//建造者模式
	//适合类中属性比较复杂的情况
	public static void main(String[] args) {
		ComplexBuilder build = new ComplexBuilder();
		Builder builder = build.buildPart1()
									.buildPart2()
									.build();
		System.out.println(builder.toString());
	}
}
