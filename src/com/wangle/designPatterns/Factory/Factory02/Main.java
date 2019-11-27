package com.wangle.designPatterns.Factory.Factory02;

import com.wangle.designPatterns.Factory.Factory01.*;

public class Main {
	//目前：不同交通工具具有不同的工厂（完成任意交通工具factory生成对象的扩展），每种交通工具都实现Moveable（完成任意交通工具的扩展）
	//
	public static void main(String[] args) {
		CarFactory factory = CarFactory.getInstance();
//		Moveable c = factory.create();
//		c.go();
		Moveable p = PlaneFactory.getInstance().create();
		p.go();
	}
}
