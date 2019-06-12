package com.wangle.Factory;

public class Factory {
	public static Person getInstance(String type,String name,int age,double args){
		Person p =null;
		if(type.equals("student")){
			p = new Student(name,age,args);
		}else if(type.equals("worker")){
			p = new Worker(name,age,args);
		}else{
			return null;
		}
			return p;
	}
}
