package com.wangle.algorithm;

public class Test021 {

	//�жϵ������Ƿ��л��������ҳ�,�뻷�ڵ�
	public static void main(String[] args) {
		Node head = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		head.next  = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node2;
		//����һ��ʱ��ʱ�����ԭ��һ���ܵؿ�һ���ܵ����������ܻ�������
		Node low = head;
		Node fast = head;
		while(low!=null){
			low = low.next;
			fast = fast.next.next;
			if(low == fast){
				System.out.println(fast.id);
				break;
			}
		}
		
		Node cross = fast;
		//�����ٶ���ͬ�ģ�һ���������������һ����head������һ�������뻷���������������ݹ�ʽ�Ƶ�����
		Node runner = cross;
		Node walker = head;
		while(walker!=null){
			
			runner = runner.next;
			walker = walker.next;
			if(runner == walker){
				System.out.println(walker.id);
				break;
			}
		}
	}
	
	static class Node{
		
		private int id;
		private Node next;
		
		public Node(int id){
			this.id = id;
		}
	}
}
