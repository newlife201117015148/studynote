package com.wangle.designPatterns.strategy.strategy03;

import java.util.Arrays;


public class Strategy03 {
	
	//可以把策略模式看作是对一种行为的抽离成一个接口，不同的实现可以表现出不同的形式。大大提高了代码的解耦和扩展性。
	//说到底就是一种多态
	public static void main(String[] args) {
		Cat[] cat = {new Cat(1,1),new Cat(3,3),new Cat(2,2),new Cat(5,5),new Cat(4,4)};
		Dog[] dog = {new Dog(1,1),new Dog(3,3),new Dog(2,2),new Dog(5,5),new Dog(4,4)};
		sort(cat,new CatHeightComparetor());//支持任何类型，任何比较策略。Comparetor就是策略模式的一种实现。
//		sort(dog,new DogWeightComparetor());
		sort(dog,new Comparetor<Dog>() {

			@Override
			public int compare(Dog o1, Dog o2) {
				if(o1.getHeight()<o2.getHeight()) return 1;
				if(o1.getHeight()>o2.getHeight()) return -1;
				return 0;
			}
		});
		System.out.println(Arrays.toString(cat));
		System.out.println(Arrays.toString(dog));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(Object[] arr,Comparetor c){
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(c.compare(arr[i],arr[j])>0){
					Object temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}

