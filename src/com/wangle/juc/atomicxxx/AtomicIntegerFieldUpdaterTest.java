package com.wangle.juc.atomicxxx;

import java.util.concurrent.atomic.*;

public class AtomicIntegerFieldUpdaterTest {
	/*
	 * AtomicXXXFieldUpdater 一般都用在java的源码开发者，普通开发者很少用到。
	 * 
	 * 具体应用场景：
	 * 1.想让类的属性具备原子性
	 * 
	 * 2.不想使用锁（如显示锁或者synchronized）
	 * 
	 * 3.大量需要原子类型修饰的对象，相比消耗内存。如concurrentskiplistMap中的node的next和value
	 */
	public static void main(String[] args) {
		AtomicIntegerFieldUpdater<Test> aifu = AtomicIntegerFieldUpdater.newUpdater(Test.class, "age");
		Test obj = new Test();
		aifu.compareAndSet(obj, 0, 1);
		System.out.println(aifu.get(obj));
	}

	static class Test{
		protected volatile int age;
	}
	
	
	/**
	 * 易错总结：
	 * 
	 * 1.age修饰符必须是默认或者public.不包括本类。
	 * 2.age变量必须是volatile修饰。
	 * 3.变量必须存在。
	 * 4.变量类型要正确。
	 * 5.obj不能是null。
	 * 6.类的class和obj必须匹配。
	 * 
	 */
}
