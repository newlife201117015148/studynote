package com.wangle.juc.atomicxxx;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {
	
	public static void main(String[] args) {
		AtomicLong al = new AtomicLong(2123L);
		System.out.println(al.get());
		
		/**
		 * static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
		 * 
		 * �жϱ��ػ����Ƿ�֧��long�͵�����cas�����֧��ֱ��ʹ��CPUָ�� LOCK CMPXCHG����֧�־�������JVMʵ��
		 */
		
	}

}
