package com.wangle.Tread;
/**
 * 
   * @类 名： Test01
   * @功能描述： 使用实现Runnable接口的方式创建线程
   * @作者信息： wangle
   * @创建时间： 2019年5月6日下午10:27:12
   * @修改备注：
 */
public class Test01 implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable:"+Thread.currentThread().getName());
		
		
	}

	
	
}
