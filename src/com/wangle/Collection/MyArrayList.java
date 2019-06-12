package com.wangle.Collection;

import java.util.NoSuchElementException;

/**
 * 
   * @类 名： MyArrayList
   * @功能描述： 模拟ArrayList制作一个集合
   * @作者信息： wangle
   * @创建时间： 2019年4月13日下午6:42:48
   * @修改备注：
 */
public class MyArrayList {
	private Object[] objs;
	private int length;
	//集合的添加方法
	public void add(Object obj){
		if(objs==null){//先判断是否为空，如果为空，就说明是第一次赋值，并且初始化一个数组大小为5的给objs，同时把第一个值添加进数组
			objs =new Object[5];
			objs[length++] = obj;//length++的目的是先给objs[0]赋值，然后自增一次；非常符合逻辑，先装数组大小才为1嘛；
		}else{
			if(objs.length == length){//为什么要先将这段代码写在objs[length++] = obj前面，因为可能出现数组越界异常。
				Object[] objs1 = new Object[(int)(objs.length*1.5f)];//如果空间不够了，就新开辟一个空间，大小是原来的约为1.5倍，为什么不添加一个元素就增加一个位置呢，因为这样会耗费很多时间，效率极低。
				System.arraycopy(objs, 0, objs1, 0, objs.length);//此方法为操作内存赋值，比for循环赋值效率搞得多。
//				for (int i = 0; i < objs.length; i++) {
//					objs1[i] = objs[i];
//				}
				objs = objs1;
			}
			objs[length++] = obj;
		}
	}
	public void remove(int index){
		if(index<0 || index>=length){
			throw new NoSuchElementException();
		}
		
		System.arraycopy(objs, index+1, objs, index, length-index-1);
		length--;
	}
	public Object get(int index){
		return objs[index];
		
	}
	
	public int size(){
		return length;
	}
	
}
