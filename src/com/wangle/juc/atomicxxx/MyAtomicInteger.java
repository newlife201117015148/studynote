package com.wangle.juc.atomicxxx;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger {

	public static void main(String[] args) {
		/**
		 * create and get
		 * 
		 */
		AtomicInteger ai = new AtomicInteger();
		System.out.println(ai.get());
		AtomicInteger ai1 = new AtomicInteger(2);
		System.out.println(ai1.get());

		/**
		 * set
		 */
		ai.set(12);
		System.out.println(ai.get());

		ai.lazySet(13);
		System.out.println(ai.get());

		/**
		 * compareandswap相关方法
		 */
		AtomicInteger ai2 = new AtomicInteger();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				ai2.getAndAdd(1);
				System.out.println(ai2.get());
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				ai2.getAndAdd(1);
				System.out.println(ai2.get());
			}
		}).start();

		/**
		 * 尝试用atomicinteger实现trylock/unlock的功能。
		 *
		 */
		
		MyAtomicInteger my = new MyAtomicInteger();
		Mylock lock = my.new Mylock();
		for (int i = 0; i < 4; i++) {
			new Thread(()->{
				
				try {
					lock.tryLock();
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unLock();
				}
			},i+"").start();
		}

	}

	private class Mylock {
		private final AtomicInteger init = new AtomicInteger(0);
		private Thread current ;
		public void tryLock() {
			boolean success = init.compareAndSet(0, 1);
			if(!success){
				System.out.println(Thread.currentThread().getName()+"尝试获取锁，但锁已被占用");
			}else{
				current = Thread.currentThread();
				System.out.println(current.getName()+"获得锁");
			}
		}

		public void unLock() {
			if(init.get()==1&&current==Thread.currentThread()){
				init.compareAndSet(1, 0);
				System.out.println(current.getName()+"释放锁");
			}
		}
	}

}
