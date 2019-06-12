package com.wangle.Collection;

public class Test1 {
	
	public static void main(String[] args) {
		MyArrayList arr1 = new MyArrayList();
		long time = System.currentTimeMillis();
//		for (int i = 0; i < 100000; i++) {
			arr1.add("aaa");
			arr1.add("bbb");
			arr1.add("ccc");
			arr1.add("ddd");
			arr1.add("eee");
			arr1.add("fff");
			arr1.add("ggg");
			arr1.add("hhh");
			arr1.add("iii");
			arr1.add("jjj");
			arr1.add("kkk");
			arr1.remove(arr1.size()-1);
//		}
//		System.out.println(System.currentTimeMillis()-time);
		System.out.println(arr1.size());
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
	}
}
