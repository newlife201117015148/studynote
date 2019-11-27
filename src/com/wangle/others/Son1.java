package com.wangle.others;

public class Son1 extends Father1{
	private String a;
	public Son1(String a) {
		super(a+a);
		this.a = a ;
		System.out.println(a);
	}
}
