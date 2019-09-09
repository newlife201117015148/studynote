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
 * @类 名： Test2 @功能描述： TODO @作者信息： wangle @创建时间： 2019年4月28日上午10:22:51 @修改备注：
 */
public class Test2 {
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
	public static void main(String[] args) throws UnsupportedEncodingException, ParseException {

		long time = System.currentTimeMillis();
		Date date = new Date();
		System.out.println(date.getYear() + 1900);// 年要加1900
		System.out.println(date.getMonth() + 1);// 月要加1
		System.out.println(date.getDate());// 得到日
		System.out.println(date.getHours());// 得到小时 24小时制
		System.out.println(date.getMinutes());// 得到分钟
		System.out.println(date.getSeconds());// 得到秒
		System.out.println(date.getDay());// 得到星期星期天到星期六是0到6
		System.out.println(date.getTime());// 得到毫秒数
		System.out.println(time);

		//Locale.setDefault(Locale.JAPAN);// 设置默认时区
		System.out.println(date.toLocaleString());// 按系统时区显示格式

		System.out.println(new Date(time + (long) 1000 * 60 * 60 * 24 * 30).toLocaleString());
		// (long)1000*60*60*24*30 不等于（long)(1000*60*60*24*30)

		System.out.println("--------------练习------------------");
		// 计算离过年还有多久，要求到一年显示年（n年n月n日 n时n分n秒）如果不到一年（n月n日 n时n分n秒）不到一月（n日 n时n分n秒）

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
			daojishi = year + "年" + month + "月" + mydate + "天" + hours + "小时" + minutes + "分" + secondes + "秒";
		} else if (month > 0) {
			daojishi = month + "月" + mydate + "天" + hours + "小时" + minutes + "分" + secondes + "秒";
		} else if (mydate > 0) {
			daojishi = mydate + "天" + hours + "小时" + minutes + "分" + secondes + "秒";
		} else if (hours > 0) {
			daojishi = hours + "小时" + minutes + "分" + secondes + "秒";
		} else if (minutes > 0) {
			daojishi = minutes + "分" + secondes + "秒";
		} else if (secondes > 0) {
			daojishi = secondes + "秒";
		}

		System.out.println("离过年还有:" + daojishi);

		System.out.println("---------------Calendar------------------");

		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH) + 1);
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//24小时制
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println("0000000");
		// 设置时间
		calendar.set(2020, 0, 25, 0, 0, 0);
		System.out.println((calendar.getTimeInMillis()-Calendar.getInstance().getTimeInMillis())/((long)1000*60*60*24*7));//离过年还有38周

		// 时间加法
		calendar.add(Calendar.MONTH, 1);
		System.out.println(calendar.getTime().toLocaleString());

		// 计算某个月有多少天
		System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));//ActualMaximum：实际最大值

		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));// 本月的第几天
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));// 本周的第几天
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));// 本年的第几天
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));// 按七天为一周的算
		System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));// 日历的第几周
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));// 这年的第几周

		// 计算某一天是星期几
		String[] xq = { "星期天", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		System.out.println(xq[calendar.get(Calendar.DAY_OF_WEEK) - 1]);

		System.out.println("--------------------Calendar练习--------------------");

		// 做一个日历
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
		System.out.println("\t日\t一\t二\t三\t四\t五\t六");
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
		
		System.out.println("---------------------// DateFormat 日历格式类------------------------");
		
		Locale[] l = {Locale.CANADA,Locale.CHINA,Locale.US,Locale.UK};
		int[] a = {DateFormat.FULL,DateFormat.SHORT,DateFormat.MEDIUM,DateFormat.LONG};
		for (Locale i : l) {
			System.out.println("国家："+i.getDisplayCountry());
			for (int j : a) {
				System.out.println(DateFormat.getDateInstance(j, i).format(new Date()));
			}
			System.out.println("---------");
		}
		System.out.println("---------------------// SimpleDateFormat 日历格式类---------------------");
		Locale.setDefault(Locale.CHINA);
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒  EEE a  Z");
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
