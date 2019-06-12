package com.wangle.Tread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * 
   * @�� ���� Test06
   * @���������� Java �߳�wait()֮��һ��Ҫnotify()���ܻ�����
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��7������3:00:46
   * @�޸ı�ע��
 */

//����Ĵ������н��������¿�ͷ���߳�״̬�������ģ�C�̺߳�main�߳��ȶ���New->Runnable->Running��Ȼ��C�߳����õ���cͬ����������
//���Կ���������main�߳̽���synchronizedͬ���飬��Ȼ����Running״̬����main�߳���Running->ͬ������������Blocked��״̬��
//C�߳�ִ����synchronizedͬ����������ͷ�cͬ������������ʱmain�̻߳����������Blocked->Runnable->Running������synchronizedͬ���顣
//��ʱ��C�̻߳���ִ��run()������main�߳�ִ�е�c.wait()ʱ���ִ�Running->�ȴ�Blocked��ͬʱ�ͷ�cͬ�����������ؼ�ʱ�����ˣ�C�߳�ִ����run()������
//C�߳��������������̶߳���c���е�wait()�̣߳�����Ҳ����main�̣߳��˳��ȴ����У��൱�ڻ��ѣ�notify()/notifyAll()������main�̴߳ӵȴ�Blocked->����Blocked��
//�ٻ�ȡͬ��������������Blocked->Runnable->Running��������֤������Ļ����൱��notifyAll()����������ҾͲ����ˣ�����Ȥ����ȥ��֤һ�¡�
//
//���ԣ�������main�߳����õ�cͬ�������������н��Ҳ�ǻ������˳�����������Ұ�C�߳�ѭ��Thread.sleep(100)ע�͵���������ܾͲ�һ���ˣ�
//��Ϊmain�̵߳�c.wait()��������C�߳�����������ִ�еģ�C�߳���������ʱ��û�п��Ի��ѵ���c�̶߳���wait()���̣߳��ȴ������ǿյġ�����֮��main�߳�ִ�е�
//c.wait()�������뵽�ȴ������У��Ѿ�û��˭ȥ�������ˣ�����main�߳̽���һֱ���ڵȴ�״̬������һֱ���У��޷������˳���
public class Test06 {
	 public static void main(String[] args)
	    {
	        ThreadB b = new ThreadB();
	        ThreadC c = new ThreadC();
	        c.setName("c�߳�");
	        b.setName("b�߳�");
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
