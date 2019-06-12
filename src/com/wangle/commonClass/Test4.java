package com.wangle.commonClass;

import java.awt.AWTException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashSet;
import java.util.Random;

/**
 * @�� ���� Test2 @���������� TODO @������Ϣ�� wangle @����ʱ�䣺 2019��4��28������10:22:51 @�޸ı�ע��
 */
public class Test4 {
	// String �ַ�����
	// StringBuffer �����ַ���(ͬ��)
	// StringBuilder �����ַ�������ͬ����

	// Integer/Bouble/Float/Character/Long/Short/Byte/Boolean ��װ��

	// System ϵͳ��
	// Runtime �����࣬����ִ��dos����
	//
	// Date ������
	// Calendar ������
	// DateFormat ������ʽ��
	// SimpleDateFormat ������ʽ��
	// Locale ʱ����
	//
	// Math ��ѧ��
	// Random �������
	// BigDecimal ��������
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

		// float��double�����ڼ����ϻ�����BigDecimal������������
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
		// MathContext����λ�������뷽ʽ
		System.out.println(decimal.doubleValue());
		System.out.println(new BigDecimal(0.1).toString());// ���ܱ�ʾ0.1
		System.out.println(new BigDecimal("0.1").toString());// ���Խ��ַ�����ȷ�ı�ʾ
		System.out.println(
				new BigDecimal(Double.toString(0.1000000000000000055511151231257827021181583404541015625)).toString());// double.tostring()������Ҫ�������������

		System.out.println("--------------------��ϰ----------------");
		// ʮ���������ѡ��3���ˣ����ظ�
		// String[] persons =
		// {"����","��С��","����","С����","����","��ӹ","��С��","����","������","��ԥ"};
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
		// ʮ���������ѡ��3���ˣ����ظ�
		String[] persons1 = { "����", "��С��", "����", "С����", "����", "��ӹ", "��С��", "����", "������", "��ԥ" };
		HashSet<String> selects1 = new HashSet<String>();
		Random random2 = new Random();
		while (selects1.size() < 3) {
			selects1.add(persons1[random2.nextInt(10)]);
		}
		for (String string : selects1) {
			System.out.println(string);
		}

		// 33������ѡ6�����֣�16����ѡ1����ѡ�������ֵ��߲����ظ�
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
		// ���ܽ���"ABC"��������

		//����
		String str = jiami("ABC".toCharArray());
		System.out.println(str);
		//����
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
			System.out.println("��֤��ȷ");
		}else{
			System.out.println("��֤����");
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
