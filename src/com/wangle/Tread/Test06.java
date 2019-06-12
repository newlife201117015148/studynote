package com.wangle.Tread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * 
   * @类 名： Test06
   * @功能描述： Java 线程wait()之后一定要notify()才能唤醒吗？
   * @作者信息： wangle
   * @创建时间： 2019年5月7日下午3:00:46
   * @修改备注：
 */

//上面的代码运行结果结合文章开头的线程状态是这样的：C线程和main线程先都由New->Runnable->Running，然后C线程先拿到了c同步对象锁，
//所以可以优先于main线程进入synchronized同步块，仍然保持Running状态，而main线程由Running->同步阻塞（锁定Blocked）状态。
//C线程执行完synchronized同步块后，立即释放c同步对象锁。此时main线程获得锁，锁定Blocked->Runnable->Running，进入synchronized同步块。
//这时候，C线程还在执行run()方法，main线程执行到c.wait()时，又从Running->等待Blocked，同时释放c同步对象锁。关键时候来了，C线程执行完run()方法后，
//C线程正常结束，以线程对象c运行的wait()线程（这里也就是main线程）退出等待队列，相当于唤醒，notify()/notifyAll()，所以main线程从等待Blocked->锁定Blocked，
//再获取同步对象锁，锁定Blocked->Runnable->Running。经过验证，这里的唤醒相当于notifyAll()，这里代码我就不贴了，有兴趣可以去验证一下。
//
//所以，倘若是main线程先拿到c同步对象锁，运行结果也是会正常退出。但是如果我把C线程循环Thread.sleep(100)注释掉，结果可能就不一样了：
//因为main线程的c.wait()方法是在C线程正常结束后执行的，C线程正常结束时并没有可以唤醒的以c线程对象wait()的线程，等待队列是空的。所以之后当main线程执行的
//c.wait()方法进入到等待队列中，已经没有谁去唤醒它了，所以main线程将会一直处于等待状态，程序一直运行，无法正常退出。
public class Test06 {
	 public static void main(String[] args)
	    {
	        ThreadB b = new ThreadB();
	        ThreadC c = new ThreadC();
	        c.setName("c线程");
	        b.setName("b线程");
	        c.start();
	        System.out.println(Thread.currentThread().getName()+"is start....");
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	 
	        synchronized(c)
	        {
	            try
	            {
	                System.out.println(Thread.currentThread().getName()+" synchronized method is beginning");
	                System.out.println(c.isAlive());
	                Thread.sleep(1000);
	                System.out.println(c.isAlive());
	                System.out.println(Thread.currentThread().getName()+ " is waiting");
	                c.wait();
	                System.out.println("now back to "+
	                        Thread.currentThread().getName());
	                b.start();
	            }
	            catch(InterruptedException e)
	            {
	            }
	        }
	    }
}
