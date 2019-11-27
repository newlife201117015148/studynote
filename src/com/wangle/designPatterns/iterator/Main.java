package com.wangle.designPatterns.iterator;

public class Main {
	//������ģʽ
	//���������ʵ�ֲ�ͬ���������й�ͬ�ĵ�����
	//������������ȼ��ϱ����й�ͬ��ʵ�ֽӿڣ�Ȼ����Ҫ׼��һ�����õĵ������ӿڣ�����hasnext������next����������Ȼ��ÿ������ȥʵ�־����ȡֵ��ʽ��
	
	public static void main(String[] args) {
		ArrayList_ myarr = new ArrayList_();
		for (int i = 0; i < 15; i++) {
			myarr.add(i);
		}
		System.out.println(myarr.getSize());
		
		LinkedList_ mylist = new LinkedList_();
		mylist.add("1");
		mylist.add("2");
		mylist.add("3");
		mylist.add("4");
		mylist.add("5");
		mylist.add("6");
		System.out.println(mylist.getSize());
		
		Iterator_ iter = mylist.getIterator_();
		while(iter.hasNext()){
			Node node = (Node)iter.next();
			System.out.println(node.getValue());
		}
		
	}
	static interface Collection_{
		int getSize();
		
		Iterator_ getIterator_();
	}
	static interface Iterator_{
		boolean hasNext();
		Object next();
	}
	static class ArrayList_ implements Collection_{
		private int size;
		private int[] arr = new int[10];
		
		
		public void add(int element){
			if(arr.length == size){
				int[] newarr = new int[arr.length*2];
				System.arraycopy(arr, 0, newarr, 0, arr.length);
				arr = newarr;
			}
			arr[size] = element;
			size++;
		}
		
		public int getSize(){
			return size;
		}
		public Iterator_ getIterator_(){
			return new ListIterator_();
		}
		private  class ListIterator_ implements Iterator_{
			int index = 0;
			@Override
			public boolean hasNext() {
				if(index >= size) return false;
				return true;
			}

			@Override
			public Object next() {
				// TODO Auto-generated method stub
				int re = arr[index];
				index ++;
				return re;
			}
			
		}
	}
	
	
	static class LinkedList_ implements Collection_{
		private Node head;
		private Node tail;
		
		private int size;
		public LinkedList_() {
		}
		
		public Node getHead(){
			return head;
		}
		public void add(String node){
			Node n = new Node(node);
			if(head == tail&&head==null) 
				head =tail = n;
			else if(head != null){
				Node temp = head;
				while(temp.next!=null){
					temp = temp.next;
				}
				if(temp.next==null){
					temp.next = n;
					n.pre = temp;
					tail = n;
				}
			}
			size ++;	
		}
		
		public int getSize(){
			return size;
		}
		
		public Iterator_ getIterator_(){
			return new ListIterator_();
		}
		private  class ListIterator_ implements Iterator_{
			int index = 0;
			@Override
			public boolean hasNext() {
				if(index >= size) return false;
				return true;
			}

			@Override
			public Object next() {
				Node currentnode = head;
				for (int i = 0; i < index; i++) {
					currentnode = currentnode.next; 
				}
				index ++;
				return currentnode;
			}
			
		}
		
		
	}
	static class Node{
		private String value;
		private Node next;
		private Node pre;
		public Node(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPre() {
			return pre;
		}
		public void setPre(Node pre) {
			this.pre = pre;
		}
		
		
	}
}
