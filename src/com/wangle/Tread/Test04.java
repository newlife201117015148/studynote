package com.wangle.Tread;

/**
 * 
   * @类 名： Test04
   * @功能描述： 创建两个线程，其中一个输出1-52，另外一个输出A-Z。输出格式要求：12A 34B 56C 78D ...
   * @作者信息： wangle
   * @创建时间： 2019年5月6日下午11:28:09
   * @修改备注：
 */
public class Test04 {

	
	public static void main(String[] args) throws InterruptedException {
		Number number = new Number();
		Zimu zimu = new Zimu();
		
		number.start();
		zimu.start();
		
		number.join();
		zimu.join();
		
		
	}
}
