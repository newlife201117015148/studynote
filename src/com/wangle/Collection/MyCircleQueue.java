package com.wangle.Collection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyCircleQueue{
	
	public static void main(String[] args) {
		testCircleQueue();
	}
	public static void testCircleQueue(){

		System.out.println("循环队列测试：");
		Scanner scanner = new Scanner(System.in);
		MyQueue queue = new MyQueue(4);
		while(true){
			System.out.print("[输入(a):添加一个元素");
			System.out.print("输入(s):显示队列");
			System.out.print("输入(p):弹出一个元素");
			System.out.print("输入(e):获取一个元素]");
			System.out.println();
			char a = scanner.next().charAt(0);
			
			switch(a){
			
			case 'a':
				System.out.println("请输入一个数字");
				int element = 0;
				try {
					element = scanner.nextInt();
					queue.add(element);
				} catch (InputMismatchException e) {
					System.out.println("你的输入有误");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("队列已满");
				}
				
				break;
				
			case 's':
				try {
					queue.showQueue();
				} catch (Exception e) {
					System.out.println("队列为空");
				}
				break;
			case 'p':
				try {
					queue.pop();
				} catch (Exception e) {
					System.out.println("队列为空");
				}
				break;
			case 'e':
				try {
					queue.element();
				} catch (Exception e) {
					System.out.println("队列为空");
				}
				break;
			default:
				System.out.println("dhh ");
			}
		}
	
	}
	
	
	
	static class MyQueue {

		private int maxsize;
		private int head;
		private int tail;
		private int[] arr;
		
		public MyQueue(int maxsize) {
			this.maxsize = maxsize+1;
			arr = new int[maxsize+1];
			head = 0;
			tail = 0;
		}
		public boolean isFull(){
			return ((tail + 1)%maxsize) == head ;
		}
		public boolean isEmpty(){
			return head == tail;
		}
		public void add(int e){
			if(isFull()){
				throw new ArrayIndexOutOfBoundsException("队列已满！");
			}
			
			tail = (tail+1) % maxsize;
			arr[tail] = e;
		}
		public int pop(){
			if(isEmpty()){
				throw new ArrayIndexOutOfBoundsException("队列为空！");
			}
			
			head=(head+1)% maxsize;
			return arr[head];
		}
		
		public int element(){
			if(isEmpty()){
				throw new ArrayIndexOutOfBoundsException("队列为空！");
			}
			
			return arr[(head+1)% maxsize];
		}
		public int size(){
			int n = tail - head;
			if(n<0){
				n = tail - head + maxsize;
			}
			return n;
		}
		public void showQueue(){
			if(isEmpty()){
				throw new ArrayIndexOutOfBoundsException("队列为空！");
			}
			for (int i = head+1; i <=head+size(); i++) {
				System.out.printf("arr[%d]=%d",i% maxsize,arr[i% maxsize]);
				System.out.println();
			}
		}

	}
}

