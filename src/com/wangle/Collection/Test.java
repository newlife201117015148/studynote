package com.wangle.Collection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test extends Thread {
	Hello hello = null;
	public Test(Hello hello) {
		this.hello = hello;
	}
	@Override
	public void run() {
		if(this.getName().equals("1")){
			hello.method1();
		}else{
			hello.method2();
		}
	}
	public static void main(String[] args) {
		Hello hello = new Hello();
		Test test1 = new Test(hello);
		Test test2 = new Test(hello);
		test1.setName("1");
		test2.setName("2");
		test1.start();
		test2.start();
		// LinkedList set = new LinkedList();
		// set.add("aa1");
		// set.add("aa2");
		// set.add("aa3");
		// set.add("aa4");
		// set.add("aa5");
		// set.add("aa6");
		// set.add("aa7");
		// set.add("aa8");
		// set.add("aa9");
		// set.add("aa10");
		// set.add("aa11");
		// set.add("aa12");
		// set.add("aa13");
		// set.add(null);
		// set.add(null);
		// set.add("aa16");
		// set.add("aa17");
		// set.add("aa18");
		//// for(Object obj :set){
		//// System.out.println(obj);
		//// }
		// ListIterator it = set.listIterator(10);
		// while(it.hasPrevious()){
		// System.out.println(it.previous());
		// it.remove();
		// }
		// System.out.println(set.size());
		//
		// System.out.println();
	}
}
