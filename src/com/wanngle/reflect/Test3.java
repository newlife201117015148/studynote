package com.wanngle.reflect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
   * @类 名： Test3
   * @功能描述： 动态加载类
   * @作者信息： wangle
   * @创建时间： 2019年5月8日下午3:51:40
   * @修改备注：
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
