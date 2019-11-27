package com.wangle.Collection;

import java.util.Comparator;

public class MySingleList {

	public static void main(String[] args) {
		SingleLinkedList<String> list = new SingleLinkedList<String>();
		/*Comparator<String> c = new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {

				Collator collator = Collator.getInstance(Locale.CHINA);
				CollationKey key1 = collator.getCollationKey(o1);
				CollationKey key2 = collator.getCollationKey(o2);
				return key1.compareTo(key2);
			}
			
		};
		list.addByOrder("中", c);
		list.addByOrder("国", c);
		list.addByOrder("欢", c);
		list.addByOrder("迎", c);
		list.addByOrder("你", c);*/
		list.add("a");
		list.add("b");
		list.add("c");
		list.addByOrder("e");
		
//		list.update(0, "C");
		
		System.out.println(list.getNodeFromFirst(0));
		System.out.println(list.getNodeFromLast(5));
		
		list.reverse();
		list.showAll();
		System.out.println("list的大小："+list.getSize());
	}
	
	
	@SuppressWarnings("rawtypes")
	static class SingleLinkedList<E extends Comparable>{
		
		private int size;
		private Node<E> head;
		
		
		public void add(E e){
			addLast(e);
		}
		
		public void addFirst(E e){
			final Node<E> first = head;
			Node<E> newnode = new Node<E>(e,first);
			head = newnode;
			size++;
		}
		public void addLast(E e){
			if(head == null) {
				head = new Node<E>(e,null);
			}else{
				Node<E> element = head;
				while(element.next!=null){
					element = element.next;
				}
				Node<E> newnode = new Node<E>(e,null);
				if(element.next == null){
					element.next = newnode;
				}
			}
			size ++;
		}
		public void add(int index,E e){
			if(index<0||index>size){
				return;
			}
			Node<E> node = head;
			for (int i = 0; i < index; i++) {
				node = head.next;
			}
			Node<E> newnode = new Node<E>(e,node.next);
			node.next = newnode;
			
			size++;
		}
		@SuppressWarnings("unchecked")
		public void addByOrder(E e){
			Node<E> node = head;
			Node<E> pre = null;
			if(node == null ){
				head = new Node(e,null);
				size ++;
				return;
			}
			if(node.next == null){
				if(e.compareTo(node.item)<0){
					addFirst(e);
				}else{
					addLast(e);
				}
				return;
			}
			while(true){
				if(node==null) break;
				if(e.compareTo(node.item)<0){
					if(pre==null){
						head = new Node(e,node);
					}else{
						pre.next = new Node(e,node);
					}
					size++;
					return;
				}
				
				pre = node;
				node = node.next;
			}
			
			addLast(e);
		}
		@SuppressWarnings("unchecked")
		public void addByOrder(E e,Comparator c){
			Node<E> node = head;
			Node<E> pre = null;
			if(node == null ){
				head = new Node(e,null);
				size ++;
				return;
			}
			if(node.next == null){
				if(c.compare(e, node.item)<0){
					addFirst(e);
				}else{
					addLast(e);
				}
				return;
			}
			while(true){
				if(node==null) break;
				if(e.compareTo(node.item)<0){
					if(pre==null){
						head = new Node(e,node);
					}else{
						pre.next = new Node(e,node);
					}
					size++;
					return;
				}
				
				pre = node;
				node = node.next;
			}
			
			addLast(e);
		}
		public void remove(Object o){
			if(o==null){
				Node<E> e = null;
				Node<E> pre = null;
				for (e = head; e!=null;) {
					Node<E> next = e.next;//在操作过程中可能修改e，所以需要保存原值。
					if(e.item == null){
						if(pre == null){//判断是否是删除的第一个，如果是第一个会影响head的指向。
							head = e.next;
							e.next = null;
						}else{
							pre.next = e.next;
						}
						size--;
					}
					if(e.item!=null)//该项已经被删除，排除掉，pre保持不变
					pre = e;
					e = next;
				}
			}else{
				Node<E> e = null;
				Node<E> pre = null;
				for (e = head; e!=null;) {
					Node<E> next = e.next;//在操作过程中可能修改e，所以需要保存原值。
					if(o.equals(e.item)){
						if(pre == null){
							head = e.next;
							e.next = null;
						}else{
							pre.next = next;
							e.next = null;
						}
						size--;
					}
					if(!o.equals(e.item))//该项已经被删除，排除掉，pre保持不变
					pre = e;
					e = next;
				}
			}
			
		}
		public void update(int index,E e){
			if(index<0) return;
			int count = 0;
			for(Node<E> node = head;node!=null;node = node.next){
				if(count == index){
					node.item = e;
				}
				count ++;
			}
		}
		public Node<E> getNodeFromLast(int num){
			if(num<0||num>size-1)
				return null;
			int size = getSize();
			Node<E> node = head;
			for(int i=0;i<size-num-1;i++){
				node = node.next;
			}
			
			return node;
		}
		public Node<E> getNodeFromFirst(int num){
			if(num<0||num>=size-1)
				return null;
			Node<E> node = head;
			for(int i=0;i<num;i++){
				node = node.next;
			}
			
			return node;
		}
		public int getSize(){
			return size;
		}
		public void reverse(){
			/*if(size==0||size==1) return;
			Node<E> newHead = null;
			for (int i=0;i<size-1;i++) {
				if(i==0) newHead = getNodeFromLast(i);
				Node<E> next = getNodeFromLast(i+1);
				getNodeFromLast(i).next = next;
				if(size-2==i) next.next = null;
			}
			head = newHead;*/
			head = reverse(this.getHead());
		}
		private Node<E> reverse(Node<E> head) {
		    /*递归方法
		    if (head == null || head.next == null)
			return head;
			Node<E> temp = head.next;
		    Node<E> newHead = reverse(head.next);
		    temp.next = head;
		    head.next = null;
		    return newHead;
		    */
			//遍历方法
		    Node<E> pre = null;
		    Node<E> next = null;
		    while(head!=null){
		    	next = head.next;
		    	head.next = pre;
		    	pre = head;
		    	head = next;
		    }
		    return pre;
		}
		public Node<E> getHead(){
			return head;
		}
		public void showAll(){
			int index = 0;
			for (Node<E> e = head; e!=null; e = e.next) {
				System.out.print("list["+index+"]="+e);
				System.out.println();
				index++;
			}
		}
		
		
		
		
		
		
		private static class Node<E extends Comparable>{
			private E item;
			private Node<E> next;
			
			@SuppressWarnings("unused")
			public Node(E item,Node<E> next) {
				this.item = item;
				this.next = next;
			}

			@Override
			public String toString() {
				return "Node [item=" + item + "]";
			}
			
		}
	}


}
