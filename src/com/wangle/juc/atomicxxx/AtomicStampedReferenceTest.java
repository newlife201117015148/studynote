package com.wangle.juc.atomicxxx;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.*;

public class AtomicStampedReferenceTest {
	/**
	 *解决CAS中ABA问题，加入版本号
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(100,0);
		
		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				asr.compareAndSet(100, 101, asr.getStamp(), asr.getStamp()+1);
				asr.compareAndSet(101, 100, asr.getStamp(), asr.getStamp()+1);
			}
		};
		int stamp = asr.getStamp();
		Thread t2 = new Thread(){
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
					boolean result = asr.compareAndSet(100, 101, stamp, stamp+1);
					System.out.println(result);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
	
	/*public static void main(String[] args) throws InterruptedException {
		AtomicReference<Integer> asr = new AtomicReference<>(100);
		
		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				asr.compareAndSet(100, 101);
				asr.compareAndSet(101, 100);
			}
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
					boolean result = asr.compareAndSet(100, 101);
					System.out.println(result);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}*/

}
