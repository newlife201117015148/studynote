package com.wangle;
/**
 * 
   * @�� ���� Test2
   * @���������� ����ģʽ
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��4��1������8:25:48
   * @�޸ı�ע��
 */
public class Test2 extends Thread{
	public void run(){
		try {
			Thread.sleep(1000);
			
			for(int i=0;i<10000;i++){
				Student3.getStudent();
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
//		Student stu = Student.getStudent();
//		stu.setName("wangerxiao");
//		stu.setAge(10);
//		System.out.println(stu);
//		
//		Student stu2 = Student.getStudent();
//		stu2.setName("dongcunrui");
//		System.out.println(stu);
		Test2[] threads = new Test2[10000];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Test2();
		}
		
		long time = System.currentTimeMillis();
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		
		System.out.println(System.currentTimeMillis()-time -1000);
	}
}
