package com.wangle.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MyHashSet {
	
	private Object[] objs =  new Object[3];
	
	public void add(Object obj){
		if(obj==null){
			throw new NullPointerException("null");
		}
		int code = obj.hashCode();
		if(code<0){
			code = ~code;//取反
		}
		int index = code%objs.length;
		
//		Object[] objs1= (Object[]) objs[index];
//		if(objs[index]==null){
//			objs1= new Object[]{obj,null,null};
//			
//			objs1[2] = objs1;
//			objs[index] = objs1;
//		}else{
//			if(objs1[1]==null){
//				Object[] temp = new Object[]{obj,null};
//				objs1[1] = temp;
//				objs1[2] = temp;
//			}else{
//				Object[] temp = new Object[]{obj,null};
//				Object[] weiba = (Object[]) objs1[2];
//				weiba[1] = temp;
//				objs1[2] = temp;
//			}
//		}
		/**
		 * 改进
		 */
		if(objs[index]==null){
			Object[] temp = new Object[]{obj,null,null};
			temp[2] = temp;
			objs[index] = temp;
		}else{
			Object[] objs1= (Object[]) objs[index];
			Object[] weiba= (Object[]) objs1[2];
			Object[] temp = new Object[]{obj,null};
			weiba[1] = temp;
			objs1[2] = temp;
		}
		
	}

	public boolean contains(Object obj){
		if(obj==null){
			throw new NullPointerException();
		}
		int code = obj.hashCode();
		
		if(code<0){
			code = ~code;//取反
		}
		int index = code%objs.length;
		
//		Object[] objs1= (Object[]) objs[index];
//		
//		if(objs1==null){
//			return false;
//		}else{
//			Object[] temp = (Object[]) objs[index];
//			while(true){
//				if(obj.equals(temp[0])){
//					return true;
//				}else{
//					if(temp[1]==null){
//						return false;
//					}else{
//						temp = (Object[]) temp[1];
//					}
//				}
//				
//			}
//		}
		/**
		 * 改进
		 */
		if(objs[index]==null){
			return false;
		}else{
			Object[] temp = (Object[]) objs[index];
			while(true){
				if(temp==null){
					return false;
				}
				if(obj.equals(temp[0])){
					return true;
				}else{
					temp = (Object[]) temp[1];
				}
				
			}
		}
	}

	public boolean remove(Object obj){
		if(obj==null){
			throw new NullPointerException();
		}
		int code = obj.hashCode();
		
		if(code<0){
			code = ~code;//取反
		}
		
		int index = code%objs.length;
		
		Object[] objs1= (Object[]) objs[index];
		if(objs1==null){
			return false;
		}else{
			if(contains(obj)){
				if(objs1[0].equals(obj)){//判断是否在首家
					if(objs1[1]==null){//是首家，链条只有一个
						objs[index] =null;
						return true;
					}else{//是首家，但链条不只一个
						Object[] next = (Object[]) objs1[1];
						objs1[0]=next[0];
						objs1[1]=next[1];
						if(objs1[2]==next){
							objs1[2]=objs1;
						}
						return true;
					}
				}else{//不是在首家
					Object[] next = (Object[]) objs1[1];
					Object[] shangjia = null;
					while(true){
						if(next == null){
							return false;
						}
						if(next[0].equals(obj)){
							if(objs1[1]==next){//next是第二个
								if(objs1[2]==next){//next是第二个，并且该链条只有两个
									objs1[1] = null;
									objs1[2] = objs1;
									return true;
								}else{//next是第二个，并且该链条不只两个
									objs1[1] = next[1];
									return true;
								}
							}else{//next不是第二个
								if(next==objs1[2]){//next是尾巴
									shangjia[1] = null;
									objs1[2] = shangjia;
									return true;
								}else{//next不是尾巴
									shangjia[1] = next[1];
									return true;
								}
							}
						}
						shangjia = next;
						next = (Object[]) next[1];
					}
				}
			}else{
				return false;
			}
		}
	}
	public static void main(String[] args) {
		MyHashSet hashset = new MyHashSet();
		int zuidabeishu = 0;
		for (int i = 0; i < 100000; i++) {
			hashset.add("aaa"+i);
		}
		for (int i = 0; i < 100000; i++) {
			if(3*i >100000){
				zuidabeishu=3*(i-1);
				break;
			}
		}
		boolean a = hashset.contains("aaa"+zuidabeishu);
		long time = System.currentTimeMillis();
		hashset.remove("aaa"+zuidabeishu);
		System.out.println(System.currentTimeMillis()-time);
		System.out.println(a);
	}
}
