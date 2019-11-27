package com.wangle.juc.atomicxxx;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {
	
	public static void main(String[] args) {
		/**
		 * create and get
		 */
		AtomicBoolean ab = new AtomicBoolean();
		System.out.println(ab.get());
		
		AtomicBoolean ab1 = new AtomicBoolean(true);
		System.out.println(ab1.get());
		
		/**
		 * set
		 */
		AtomicBoolean ab2 = new AtomicBoolean();
		ab2.set(true);
		System.out.println(ab2.get());
		
		/**
		 * compareAndSet
		 */
		AtomicBoolean ab3 = new AtomicBoolean();
		boolean a = ab3.compareAndSet(false, true);
		System.out.println(a);
		
		//¿É´úÌæ volatile boolean
	}

}
