package com.wangle.Tread;

public class ThreadB extends Thread{
	int total;
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+" is running..");
        synchronized(this)
        {
 
            for(int i=0;i<10;i++)
            {
                total +=i;
            }
            System.out.println("total is "+total);
        }
    }

}
