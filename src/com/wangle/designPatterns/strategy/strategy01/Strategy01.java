package com.wangle.designPatterns.strategy.strategy01;

import java.util.Arrays;


public class Strategy01 {
	
	
	public static void main(String[] args) {
		Cat[] cat = {new Cat(1,1),new Cat(3,3),new Cat(2,2),new Cat(5,5),new Cat(4,4)};
		Dog[] dog = {new Dog(1,1),new Dog(3,3),new Dog(2,2),new Dog(5,5),new Dog(4,4)};
		sort(cat);
		sort(dog);
		System.out.println(Arrays.toString(cat));
		System.out.println(Arrays.toString(dog));
	}
	
	public static void sort(Comparable[] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i].compareto(arr[j])>0){
					Comparable temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}

