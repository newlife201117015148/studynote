package com.wangle.commonClass;

import java.awt.AWTException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashSet;
import java.util.Random;

/**
 * @类 名： Test2 @功能描述： TODO @作者信息： wangle @创建时间： 2019年4月28日上午10:22:51 @修改备注：
 */
public class Test4 {
	// String 字符串类
	// StringBuffer 缓冲字符串(同步)
	// StringBuilder 缓冲字符串（不同步）

	// Integer/Bouble/Float/Character/Long/Short/Byte/Boolean 包装类

	// System 系统类
	// Runtime 运行类，可以执行dos命令
	//
	// Date 日期类
	// Calendar 日历类
	// DateFormat 日历格式类
	// SimpleDateFormat 日历格式类
	// Locale 时区类
	//
	// Math 数学类
	// Random 随机数类
	// BigDecimal 大数字类
	//
	// Toolkit
	// Robot
	//
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		System.out.println("--------------------------Math---------------------------");
		System.out.println(Math.random() * 100);
		System.out.println(Math.ceil(15.4d));
		System.out.println(Math.floor(14.5));
		System.out.println(Math.round(15.5f));
		System.out.println(Math.abs(-98));
		System.out.println(Math.PI);
		System.out.println(Math.E);
		System.out.println("--------------------------Random---------------------------");
		Random random = new Random();
		System.out.println(random.nextInt(100));
		System.out.println("--------------------------BigDecimal---------------------------");

		float a = 15.5f;
		for (int i = 0; i < 10; i++) {
			a += 0.1F;
		}
		System.out.println(a);

		// float和double类型在计算上会有误差，BigDecimal解决了这个问题
		BigDecimal decimal = new BigDecimal(15.5);

		for (int i = 0; i < 10; i++) {
			decimal = decimal.add(new BigDecimal(0.1));
		}
		System.out.println(decimal.doubleValue());
		for (int i = 0; i < 10; i++) {
			decimal = decimal.subtract(new BigDecimal(0.1));
		}
		System.out.println(decimal.doubleValue());
		// for (int i = 0; i < 10; i++) {
		decimal = decimal.multiply(new BigDecimal(1.01), new MathContext(3));
		// }
		// MathContext保留位数和舍入方式
		System.out.println(decimal.doubleValue());
		System.out.println(new BigDecimal(0.1).toString());// 不能表示0.1
		System.out.println(new BigDecimal("0.1").toString());// 可以将字符串正确的表示
		System.out.println(
				new BigDecimal(Double.toString(0.1000000000000000055511151231257827021181583404541015625)).toString());// double.tostring()方法是要进行四舍五入的

		System.out.println("--------------------练习----------------");
		// 十个人中随机选出3个人，不重复
		// String[] persons =
		// {"张三","王小二","二蛋","小沈阳","霍金","金庸","释小龙","古龙","查良镛","齐豫"};
		// String[] selects = {"","",""};
		// for (int i = 0; i < 3; i++) {
		// int random1 = new Random().nextInt(10);
		// System.out.println(persons[random1]);
		// for (int j = 0; j < selects.length; j++) {
		// while(persons[random1].equals(selects[j])){
		// j=0;
		// random1 = new Random().nextInt(10);
		// }
		// }
		// selects[i] = persons[random1];
		// }
		// System.out.println(Arrays.toString(selects));
		// 十个人中随机选出3个人，不重复
		String[] persons1 = { "张三", "王小二", "二蛋", "小沈阳", "霍金", "金庸", "释小龙", "古龙", "查良镛", "齐豫" };
		HashSet<String> selects1 = new HashSet<String>();
		Random random2 = new Random();
		while (selects1.size() < 3) {
			selects1.add(persons1[random2.nextInt(10)]);
		}
		for (String string : selects1) {
			System.out.println(string);
		}

		// 33以内中选6个数字，16以内选1个，选出的数字单边不能重复
		String[] persons2 = new String[33];
		for (int i = 0; i < 33; i++) {
			persons2[i] = "" + (i + 1);
		}
		HashSet<String> selects2 = new HashSet<String>();
		Random random3 = new Random();
		while (selects2.size() < 6) {
			selects2.add(persons2[random3.nextInt(33)]);
		}
		for (String string : selects2) {
			System.out.print("\t" + string);
		}

		String[] persons3 = new String[16];
		for (int i = 0; i < 16; i++) {
			persons3[i] = "" + (i + 1);
		}
		HashSet<String> selects3 = new HashSet<String>();
		Random random4 = new Random();
		while (selects3.size() < 1) {
			selects3.add(persons3[random4.nextInt(16)]);
		}
		for (String string : selects3) {
			System.out.print("\t" + string);
		}
		System.out.println();
		// 加密解密"ABC"，二进制

		//加密
		String str = jiami("ABC".toCharArray());
		System.out.println(str);
		//解密
		jiemi(str);
	}
	
	public static void jiemi(String jiami){
		String jiaoyan = jiami.substring(jiami.length()-2);
		int number = 0;
		char[] charArray = jiami.substring(0, jiami.length()-2).toCharArray();
		for (int i = 0; i <charArray.length; i+=2) {
			int j = Integer.parseInt(charArray[i]+""+charArray[i+1], 16);
			number += j%100;
		}
		String s = Integer.toHexString(number%255);
				
		if(s.length()==1){
			s="0"+s;
		}
		
		if(jiaoyan.equalsIgnoreCase(s)){
			System.out.println("验证正确");
		}else{
			System.out.println("验证错误");
			return;
		}
		char[] nr = jiami.substring(0, jiami.length()-2).toCharArray();
		String result = "";
		for (int i = 0; i < nr.length; i+=2) {
			int k = Integer.parseInt(nr[i]+""+nr[i+1],16);
			
			result += (char)k;
		}
		
		System.out.println(result);
		
	}
	
	public static String jiami(char[] b){
		String jiami = "";
		for (int i = 0; i < b.length; i++) {
			jiami += Integer.toHexString(b[i]);
		}
		
		int number = 0;
		char[] charArray = jiami.toCharArray();
		for (int i = 0; i <charArray.length; i+=2) {
			int j = Integer.parseInt(charArray[i]+""+charArray[i+1], 16);
			number += j%100;
		}
		String s = Integer.toHexString(number%255);
				
		if(s.length()==1){
			s="0"+s;
		}
		
		jiami += s;
		
		return jiami;
	}
}
