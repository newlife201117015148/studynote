package com.wangle.juc.atomicxxx;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest {
	
	public static void main(String[] args) {
		AtomicLong al = new AtomicLong(2123L);
		System.out.println(al.get());
		
		/**
		 * static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
		 * 
		 * 判断本地机器是否支持long型的无锁cas，如果支持直接使用CPU指令 LOCK CMPXCHG，不支持就则依靠JVM实现
		 */
		
	}

}
