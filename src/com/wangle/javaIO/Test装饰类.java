package com.wangle.javaIO;

public class Test装饰类 {
	
	public static void main(String[] args) {
		
		Naicha n = new 抹茶(new 榴莲(new 奶茶()));
		System.out.println("名称:\t"+n.getName());
		System.out.println("价格 :\t"+n.getJiage()+"元");
		System.out.println("制作工序:\t"+n.getZhizuo());
	}

}
