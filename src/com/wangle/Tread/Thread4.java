package com.wangle.Tread;

public class Thread4 extends Thread{

	@Override
	public void run() {
		
		try {
			Thread.sleep(10000);//出现异常需要捕获是因为还没到时间就被叫醒
		} catch (InterruptedException e) {
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread4 test = new Thread4();
		//test.setDaemon(true);//设置子线程为守护线程，跟主线程一起走，不管子线程执行完没
		test.start();
		System.out.println("正在加载。。。");
		//test.join();//主线程等待子线程执行完了，主线程再往下执行
		test.join(4000);//子线程加入主线程，主线程等待子线程4秒，如果四秒后子线程还没加载完，就加载超时
		
		System.out.println("主线程");
		//test.wait();//与notify和notifyAll()都只能在同步方法里使用
		if(test.getState()==State.TERMINATED){
			System.out.println("加载成功");
		}else{
			System.out.println("加载超时");
			//test.start();//死亡的线程不可再次复生。
		}
		
	}
}
