package com.wangle.designPatterns.Factory.Factory02;

import com.wangle.designPatterns.Factory.Factory01.*;

public class Main {
	//Ŀǰ����ͬ��ͨ���߾��в�ͬ�Ĺ�����������⽻ͨ����factory���ɶ������չ����ÿ�ֽ�ͨ���߶�ʵ��Moveable��������⽻ͨ���ߵ���չ��
	//
	public static void main(String[] args) {
		CarFactory factory = CarFactory.getInstance();
//		Moveable c = factory.create();
//		c.go();
		Moveable p = PlaneFactory.getInstance().create();
		p.go();
	}
}
