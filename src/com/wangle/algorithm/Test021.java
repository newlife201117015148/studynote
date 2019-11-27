package com.wangle.algorithm;

public class Test021 {

	//判断单链中是否有环，并且找出,入环节点
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
		//利用一个时钟时分针的原理，一个跑地块一个跑得慢，他们总会相遇。
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
		//两个速度相同的，一个从相遇点出发，一个从head出发，一定会在入环口相遇。可由数据公式推导出。
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
