package com.wangle.juc.atomicxxx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.JButton;

public class AtomicReferenceTest {
	
	public static void main(String[] args) {
		AtomicReference<MyObject> ar = new AtomicReference<>(new MyObject("wl",213));
		
		System.out.println(ar.get());
		
		ar.set(new MyObject("a",23));
		
		boolean result = ar.compareAndSet(new MyObject("s",23), new MyObject("asd",454));
		
		System.out.println(result);
		
		JButton jb = new JButton();
		MyObject obj = new MyObject("a",23);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				obj.setId(21);
			}
		});
	}

	static class MyObject{
		public MyObject(String name, int id) {
			super();
			this.name = name;
			this.id = id;
		}
		private String name;
		private int id;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "MyObject [name=" + name + ", id=" + id + "]";
		}
		
	}
}
