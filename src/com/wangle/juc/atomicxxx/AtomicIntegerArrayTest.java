package com.wangle.juc.atomicxxx;

import java.util.concurrent.atomic.*;

public class AtomicIntegerArrayTest {
	
	public static void main(String[] args) {
		AtomicIntegerArray ata = new AtomicIntegerArray(1);
		
		System.out.println(ata.length());
	}

}
