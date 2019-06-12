package com.wangle.Tread;

/**
 * 
   * @类 名： Test07
   * @功能描述： 线程中的wait() 与 锁的关系
   * @作者信息： wangle
   * @创建时间： 2019年5月7日下午3:37:53
   * @修改备注：
 */
public class Test07 {
	 public static void main(String[] args) throws InterruptedException{
	        ThreadD b = new ThreadD();
	        //启动计算线程
	        b.start(); 
	        //线程A拥有b对象上的锁。线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者
	        synchronized (b) {
	            System.out.println("等待对象b完成计算。。。");
	            //当前线程A等待
	            b.wait();
	            System.out.println("b对象计算的总和是：" + b.total);
	        } 
	    } 

	 
//	 执行结果：
//
//	 等待对象b完成计算。。。
//	 计算完成
//	 b对象计算的总和是：5050
//
//	 如果我们将b.wait()去掉呢？结果如下：
//	 等待对象b完成计算。。。
//	 b对象计算的总和是：0
//	 计算完成
//
//	 上述的结果表明，当去掉b.wait()时，新启动的线程ThreadB与主线程ThreadA是各自执行的，没有线程等待的现象。
//	 我们想要的效果是，当线程ThreadB完成计算之后，再去取计算后的结果。所以使用了b.wait()来让主线程等待。
//	 那为什么是使用b.wait()，而不是Thread.currentThread.wait()，或者其他的呢？
//
//	 如果我们将b.wait()替换成Thread.currentThread.wait()，将会得到如下的结果：
//	 Exception in thread "main" java.lang.IllegalMonitorStateException
//	 at java.lang.Object.wait(Native Method)
//	 at java.lang.Object.wait(Object.java:485)
//	 at pa.com.thread.ThreadA.main(ThreadA.java:18)
//	 等待对象b完成计算。。。
//	 计算完成
//
//	 替换的代码Thread.currentThread.wait()好像理所当然应该如我们预期的正确啊，让当前线程处于等待状态，让其他线程先执行。
//	 我们忽略了一个很重要的问题：线程与锁是分不开的，线程的同步、等待、唤醒都与对象锁是密不可分的。
//	 线程ThreadA持有对象b的锁，我们要使用这把锁去让线程释放锁，从而让其他的线程能抢到这把锁。
//	 从我们的程序来分析就是：线程ThreadA首先持有锁对象b，然后调用b.wait()将对象锁释放，线程ThreadB争抢到对象锁b，从而执行run()方法中的计算，
//	 计算完了之后使用notify()唤醒主线程ThreadA，ThreadA得以继续执行，从而得到了我们预期的效果。
//	 （之所以ThreadB的对象锁也是b，是因为synchronized(this)中的this指向的就是ThreadB的实例b）
//	 Thread.currentThread.wait()调用的是当前线程对象（即主线程ThreadA）的wait()方法，当前线程对象ThreadA是没有被加锁的，
//	 它只是获取了对象锁b。我基本没有看到过这样的调用，一般使用的是锁对象的wait()，本例中为b.wait()
}
