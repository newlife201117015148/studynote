package com.wangle.Tread;

/**
 * 死锁
   * @类 名： Thread8
   * @功能描述： TODO
   * @作者信息： wangle
   * @创建时间： 2019年5月6日下午10:19:59
   * @修改备注：
 */
public class Thread8{
	static Thread9 B = new Thread9();
	
	static boolean jieshu = false;
	public static synchronized void method8(){
		jieshu = false;
		System.out.println("method8");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Thread8.jieshu!=false){
			Thread9.method9();
			}else{
				System.out.println("放弃Method9的访问");
			}
		jieshu = true;
	}

}
