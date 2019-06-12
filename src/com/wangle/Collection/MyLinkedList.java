package com.wangle.Collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList {

	private Object[] shoujia;
	private Object[] weiba;
	
	public void add(Object obj){
		if(shoujia ==null){
			shoujia = new Object[]{null,obj,null};
			weiba = shoujia;
		}else{
			Object[] temp = new Object[]{weiba,obj,null};
			weiba[2] = temp;
			weiba = temp;
		}
	}
	public void addFirst(Object obj){
		if(shoujia ==null){
			shoujia = new Object[]{null,obj,null};
			weiba = shoujia;
		}else{
			Object[] temp = new Object[]{null,obj,shoujia};
			shoujia[0] = temp;
			shoujia = temp;
		}
	}
	public void addLast(Object obj){
		add(obj);
	}
	public void remove(Object obj){
		if(shoujia ==null){
			throw new NoSuchElementException();
		}
		Object[] objs = shoujia;
		while(true){
			if(obj.equals(objs[1])){
				break;
			}
			objs = (Object[]) objs[2];
			if(objs==null){
				break;
			}
		}
		if(objs ==null){
			return;
		}
		if(objs == shoujia){
			removeFirst();
		}else if(objs == weiba){
			removeLast();
		}else{
			Object[] previous= (Object[]) objs[0];
			Object[] next = (Object[]) objs[2];
			previous[2] = next;
			next[0] = previous;
		}
		
	}
	public void removeFirst(){
		if(shoujia ==null){
			throw new NoSuchElementException();
		}
		if(shoujia == weiba){
			shoujia = null;
			weiba = null;
		}else{
			shoujia = (Object[]) shoujia[2];
			weiba[0] = null;
		}
	}
	public void removeLast(){
		if(shoujia ==null){
			throw new NoSuchElementException();
		}
		if(shoujia == weiba){
			shoujia = null;
			weiba = null;
		}else{
			weiba = (Object[]) weiba[0];
			weiba[2] = null;
		}
	}
	private Object[] temp = null;
	public boolean hasNext(){
		if(temp ==null){
			temp = shoujia;
			if(shoujia ==null){
				return false;
			}
			return true;
		}
		temp = (Object[]) temp[2];
		if(temp ==null){
			return false;
		}
		return true;
	}
	public Object next(){
		return temp[1];
	}
	public static void main(String[] args) {
		LinkedList<Object> list1= new LinkedList<Object>();
		list1.add("dddd");
		list1.add("dddd");
		Iterator<Object> iter = list1.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		MyLinkedList list = new MyLinkedList();
		list.add("AAA");
		while(list.hasNext()){
			System.out.println(list.next());
		}
	}
}
