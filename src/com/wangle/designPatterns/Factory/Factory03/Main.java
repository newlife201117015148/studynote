package com.wangle.designPatterns.Factory.Factory03;

import com.wangle.designPatterns.Factory.Factory01.*;

public class Main {
	//将food、weapoon、vehicle（交通工具）抽象出来作为各类产品看待，不同的实现类去实现它们，抽象工厂负责生产各类产品
	//简单来说就是将工厂和产品都抽象出来
	//具体生产什么产品，就需要具体的工厂（继承抽象工厂）
	//产品族类型自由切换，应用场景：换皮肤
	public static void main(String[] args) {
		AbstractFactory  fa = new MagicFactory();//需要换一套，直接换工厂就行，可以在配置文件中指定，更加灵活
		Vehicle c = fa.createVehicle();
		c.go();
		Weapoon a= fa.createWeapoon();
		a.shoot();
		Food f = fa.createFood();
		f.printName();
		
	}
	
	//比较、总结：工厂方法便于在产品维度进行扩展，比如除了食物、武器、交通工具，还要服饰等产品，直接加工厂就行了；
	//         抽象工厂便于在产品一族进行扩展，比如例子中的，现代人的和魔法一族的食物、武器、交通工具一样。
	//思考：那有没有在两个维度上都能兼容的方法呢，有，就是spring的bean工厂。
}
