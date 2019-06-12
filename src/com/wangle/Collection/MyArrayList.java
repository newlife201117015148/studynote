package com.wangle.Collection;

import java.util.NoSuchElementException;

/**
 * 
   * @�� ���� MyArrayList
   * @���������� ģ��ArrayList����һ������
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��4��13������6:42:48
   * @�޸ı�ע��
 */
public class MyArrayList {
	private Object[] objs;
	private int length;
	//���ϵ���ӷ���
	public void add(Object obj){
		if(objs==null){//���ж��Ƿ�Ϊ�գ����Ϊ�գ���˵���ǵ�һ�θ�ֵ�����ҳ�ʼ��һ�������СΪ5�ĸ�objs��ͬʱ�ѵ�һ��ֵ��ӽ�����
			objs =new Object[5];
			objs[length++] = obj;//length++��Ŀ�����ȸ�objs[0]��ֵ��Ȼ������һ�Σ��ǳ������߼�����װ�����С��Ϊ1�
		}else{
			if(objs.length == length){//ΪʲôҪ�Ƚ���δ���д��objs[length++] = objǰ�棬��Ϊ���ܳ�������Խ���쳣��
				Object[] objs1 = new Object[(int)(objs.length*1.5f)];//����ռ䲻���ˣ����¿���һ���ռ䣬��С��ԭ����ԼΪ1.5����Ϊʲô�����һ��Ԫ�ؾ�����һ��λ���أ���Ϊ������ķѺܶ�ʱ�䣬Ч�ʼ��͡�
				System.arraycopy(objs, 0, objs1, 0, objs.length);//�˷���Ϊ�����ڴ渳ֵ����forѭ����ֵЧ�ʸ�öࡣ
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
