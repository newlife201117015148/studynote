package com.wangle.commonClass;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.wangle.Test7.C;

/**
 * @�� ���� Test2 @���������� TODO @������Ϣ�� wangle @����ʱ�䣺 2019��4��28������10:22:51 @�޸ı�ע��
 */
public class Test2 {
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
	public static void main(String[] args) throws UnsupportedEncodingException, ParseException {

		long time = System.currentTimeMillis();
		Date date = new Date();
		System.out.println(date.getYear() + 1900);// ��Ҫ��1900
		System.out.println(date.getMonth() + 1);// ��Ҫ��1
		System.out.println(date.getDate());// �õ���
		System.out.println(date.getHours());// �õ�Сʱ 24Сʱ��
		System.out.println(date.getMinutes());// �õ�����
		System.out.println(date.getSeconds());// �õ���
		System.out.println(date.getDay());// �õ����������쵽��������0��6
		System.out.println(date.getTime());// �õ�������
		System.out.println(time);

		//Locale.setDefault(Locale.JAPAN);// ����Ĭ��ʱ��
		System.out.println(date.toLocaleString());// ��ϵͳʱ����ʾ��ʽ

		System.out.println(new Date(time + (long) 1000 * 60 * 60 * 24 * 30).toLocaleString());
		// (long)1000*60*60*24*30 �����ڣ�long)(1000*60*60*24*30)

		System.out.println("--------------��ϰ------------------");
		// ��������껹�ж�ã�Ҫ��һ����ʾ�꣨n��n��n�� nʱn��n�룩�������һ�꣨n��n�� nʱn��n�룩����һ�£�n�� nʱn��n�룩

		Date guonian = new Date(120, 0, 25, 0, 0, 0);
		Date currenttime = new Date();
		long times = -currenttime.getTime() + guonian.getTime();
		String daojishi = null;
		long year = times / ((long) 1000 * 60 * 60 * 24 * 30 * 12);
		long month = times % ((long) 1000 * 60 * 60 * 24 * 30 * 12) / ((long) 1000 * 60 * 60 * 24 * 30);
		long mydate = times % ((long) 1000 * 60 * 60 * 24 * 30) / ((long) 1000 * 60 * 60 * 24);
		long hours = times % ((long) 1000 * 60 * 60 * 24) / ((long) 1000 * 60 * 60);
		long minutes = times % ((long) 1000 * 60 * 60) / ((long) 1000 * 60);
		long secondes = times % ((long) 1000 * 60) / ((long) 1000);
		if (year > 0) {
			daojishi = year + "��" + month + "��" + mydate + "��" + hours + "Сʱ" + minutes + "��" + secondes + "��";
		} else if (month > 0) {
			daojishi = month + "��" + mydate + "��" + hours + "Сʱ" + minutes + "��" + secondes + "��";
		} else if (mydate > 0) {
			daojishi = mydate + "��" + hours + "Сʱ" + minutes + "��" + secondes + "��";
		} else if (hours > 0) {
			daojishi = hours + "Сʱ" + minutes + "��" + secondes + "��";
		} else if (minutes > 0) {
			daojishi = minutes + "��" + secondes + "��";
		} else if (secondes > 0) {
			daojishi = secondes + "��";
		}

		System.out.println("����껹��:" + daojishi);

		System.out.println("---------------Calendar------------------");

		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH) + 1);
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//24Сʱ��
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println("0000000");
		// ����ʱ��
		calendar.set(2020, 0, 25, 0, 0, 0);
		System.out.println((calendar.getTimeInMillis()-Calendar.getInstance().getTimeInMillis())/((long)1000*60*60*24*7));//����껹��38��

		// ʱ��ӷ�
		calendar.add(Calendar.MONTH, 1);
		System.out.println(calendar.getTime().toLocaleString());

		// ����ĳ�����ж�����
		System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));//ActualMaximum��ʵ�����ֵ

		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));// ���µĵڼ���
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));// ���ܵĵڼ���
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));// ����ĵڼ���
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));// ������Ϊһ�ܵ���
		System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));// �����ĵڼ���
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));// ����ĵڼ���

		// ����ĳһ�������ڼ�
		String[] xq = { "������", "����һ", "���ڶ�", "������", "������", "������", "������" };
		System.out.println(xq[calendar.get(Calendar.DAY_OF_WEEK) - 1]);

		System.out.println("--------------------Calendar��ϰ--------------------");

		// ��һ������
		calendar = Calendar.getInstance();
		int daysOfMonth = calendar.getActualMaximum(Calendar.DATE);
		System.out.println(daysOfMonth);
		int length = 0;
		if (daysOfMonth % 7 > 0) {
			length = daysOfMonth / 7 + 1;
		} else {
			length = daysOfMonth / 7;
		}
		System.out.println(length);
		calendar.set(Calendar.DATE, 1);
		int start = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println(start);
		System.out.println("\t��\tһ\t��\t��\t��\t��\t��");
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < start; j++) {
				System.out.print("\t");
			}
			for (int j = start; j < 7; j++) {
				System.out.print("\t" + calendar.get(Calendar.DAY_OF_MONTH));
				calendar.add(Calendar.DATE, 1);
			}
			System.out.println();
			start = 0;
		}
		System.out.println("------------------Locale------------");
		
		Locale.setDefault(Locale.US);
		Locale locale = Locale.getDefault();
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getDisplayLanguage());
		System.out.println("_________________________________");
		locale = Locale.TAIWAN;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getDisplayLanguage());
		System.out.println("_________________________________");
		locale = Locale.US;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getDisplayLanguage());
		System.out.println("_________________________________");
		locale = Locale.KOREA;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getDisplayLanguage());
		System.out.println("_________________________________");
		locale = Locale.GERMANY;
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getDisplayLanguage());
		System.out.println("_________________________________");
		
		System.out.println(Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR));
		
		System.out.println("---------------------// DateFormat ������ʽ��------------------------");
		
		Locale[] l = {Locale.CANADA,Locale.CHINA,Locale.US,Locale.UK};
		int[] a = {DateFormat.FULL,DateFormat.SHORT,DateFormat.MEDIUM,DateFormat.LONG};
		for (Locale i : l) {
			System.out.println("���ң�"+i.getDisplayCountry());
			for (int j : a) {
				System.out.println(DateFormat.getDateInstance(j, i).format(new Date()));
			}
			System.out.println("---------");
		}
		System.out.println("---------------------// SimpleDateFormat ������ʽ��---------------------");
		Locale.setDefault(Locale.CHINA);
		SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd��  HHʱmm��ss��  EEE a  Z");
		System.out.println(format.format(new Date()));
		
		String time1 = "2018-08-08 20:20:20";
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date data2 = format1.parse(time1);
		Date d1 = new Date();
		
		Calendar ca1 = Calendar.getInstance();
		Calendar ca2 = Calendar.getInstance();
		ca1.setTimeInMillis(d1.getTime()-data2.getTime());
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL).format(ca1.getTime()));
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(data2.toLocaleString());

	}
}
