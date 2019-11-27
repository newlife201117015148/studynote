package com.wangle.juc.atomicxxx;

import sun.misc.Unsafe;

public class UnsafeTest {
	
	/*
	 * Unsafe是由c++写的，非常强大，java中atomicXXX和concurrent包等等都是用它实现的。
	 * 在jdk1.9版本后，被舍弃。
	 */
	
	public static void main(String[] args) {
		Unsafe.getUnsafe();
	}

}
