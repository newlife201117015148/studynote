package com.wangle.Tread;
/**
 * 同步块
   * @类 名： Thread5
   * @功能描述： TODO
   * @作者信息： wangle
   * @创建时间： 2019年5月6日下午10:21:26
   * @修改备注：
 */
public class Thread5 extends Thread{

	volatile static int number =0;
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		synchronized(Thread5.class){
			for (int i = 0; i < 1000; i++) {
				number++;
			}
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		//多线程访问同一个变量，做修改问题
		Thread5[] test = new Thread5[10];
		for (int i = 0; i < test.length; i++) {
			test[i]  = new Thread5();
		}
		
		for (Thread5 thread5 : test) {
			thread5.start();
			
		}
		for (Thread5 thread5 : test) {
			thread5.join();//等所有线程执行完
		}
		System.out.println(number);
	}
}
