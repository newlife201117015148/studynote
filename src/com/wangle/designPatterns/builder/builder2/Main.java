package com.wangle.designPatterns.builder.builder2;

public class Main {
	//��Ҫ��Щ�ֶε�person���󣬾͵�����Щbuild����
	public static void main(String[] args) {
		Person p = new Person.PersonBuilder()//��̬�ڲ���Ĵ�������
						.builderPart1(1231, "boy", 12)
						.builderPart2("�Ĵ�", 50, 120)
						.builderPart3(99)
						.end();
		
		System.out.println(p);
	}
}
