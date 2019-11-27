package com.wangle.designPatterns.Factory.Factory03;

import com.wangle.designPatterns.Factory.Factory01.*;

public class Main {
	//��food��weapoon��vehicle����ͨ���ߣ����������Ϊ�����Ʒ��������ͬ��ʵ����ȥʵ�����ǣ����󹤳��������������Ʒ
	//����˵���ǽ������Ͳ�Ʒ���������
	//��������ʲô��Ʒ������Ҫ����Ĺ������̳г��󹤳���
	//��Ʒ�����������л���Ӧ�ó�������Ƥ��
	public static void main(String[] args) {
		AbstractFactory  fa = new MagicFactory();//��Ҫ��һ�ף�ֱ�ӻ��������У������������ļ���ָ�����������
		Vehicle c = fa.createVehicle();
		c.go();
		Weapoon a= fa.createWeapoon();
		a.shoot();
		Food f = fa.createFood();
		f.printName();
		
	}
	
	//�Ƚϡ��ܽ᣺�������������ڲ�Ʒά�Ƚ�����չ���������ʳ���������ͨ���ߣ���Ҫ���εȲ�Ʒ��ֱ�Ӽӹ��������ˣ�
	//         ���󹤳������ڲ�Ʒһ�������չ�����������еģ��ִ��˵ĺ�ħ��һ���ʳ���������ͨ����һ����
	//˼��������û��������ά���϶��ܼ��ݵķ����أ��У�����spring��bean������
}
