package com.wangle.Tread;

public class TicketsOffice extends Thread{
	static   int tickets = 20;
	
//	public TicketsOffice(int tickets){
//		this.tickets = tickets;
//	}
	
	@Override
	public void run() {

			while(tickets>0){
				synchronized (TicketsOffice.class) {
				if(tickets==0){
					System.out.println("Ʊ�Ѿ�������");
				}else{
					try {
						Thread.sleep(100);
						System.out.println(Thread.currentThread().getName()+"����һ�ţ���ʣ"+--tickets+"��");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
