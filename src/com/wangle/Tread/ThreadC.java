package com.wangle.Tread;

public class ThreadC extends Thread{
	int sum=1;
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"is running..");
        synchronized(this)
        {
            System.out.println(Thread.currentThread().getName()+" synchronized method is beginning");
            for(int i=1;i<10;i++)
            {
                sum *=i;
            }
            System.out.println(Thread.currentThread().getName()+" synchronized method is ending");
//            notify();
        }
        for (int i=0;i<50;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("c线程运行结束");
    }
}
