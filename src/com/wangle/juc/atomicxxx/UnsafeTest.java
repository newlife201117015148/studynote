package com.wangle.juc.atomicxxx;

import sun.misc.Unsafe;

public class UnsafeTest {
	
	/*
	 * Unsafe����c++д�ģ��ǳ�ǿ��java��atomicXXX��concurrent���ȵȶ�������ʵ�ֵġ�
	 * ��jdk1.9�汾�󣬱�������
	 */
	
	public static void main(String[] args) {
		Unsafe.getUnsafe();
	}

}
