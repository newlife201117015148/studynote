package com.wangle.designPatterns.builder.builder1;

public class Main {
	//������ģʽ
	//�ʺ��������ԱȽϸ��ӵ����
	public static void main(String[] args) {
		ComplexBuilder build = new ComplexBuilder();
		Builder builder = build.buildPart1()
									.buildPart2()
									.build();
		System.out.println(builder.toString());
	}
}
