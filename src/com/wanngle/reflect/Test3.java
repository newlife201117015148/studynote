package com.wanngle.reflect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
   * @�� ���� Test3
   * @���������� ��̬������
   * @������Ϣ�� wangle
   * @����ʱ�䣺 2019��5��8������3:51:40
   * @�޸ı�ע��
 */
public class Test3 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("config.properties"));
		String string = reader.readLine().split("=")[1];
		Class clazz = Class.forName(string);
		Person p = (Person)clazz.newInstance();
		String words = p.say();
		System.out.println(words);
	}

}
