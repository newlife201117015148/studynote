package com.wangle.commonClass;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @类 名： Test1 @功能描述： 对Stirng StringBuffer StringBuilder进行练习 @作者信息：
 *    wangle @创建时间： 2019年4月28日上午1:09:14 @修改备注：
 */
public class Test1 {
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
	//延伸：
//	Class 类类
//	File 文件类
//	Timer 时间类
	public static void main(String[] args) throws UnsupportedEncodingException {
		// String str1="ABC" 可能创建一个对象或者不创建对象，如果"ABC"这个字符串在java String池里不存在，
		// 会在java String池创建这个一个String对象("ABC").如果已经存在，str1直接reference to
		// 这个String池里的对象。
		// String str2 = new String("ABC") 至少创建一个对象，也可能两个。因为用到new 关键字，会在heap创建一个
		// str2 的String 对象，
		// 它的value 是 "ABC".同时，如果"ABC"这个字符串在java String池里不存在，会在java
		// String池创建这个一个String对象("ABC").
		// String str3 = "ABC";
		// String str4 = "ABC";
		// String str5 = "A" + "BC";
		// str3 == str4 的值是True 还是False呢？ True.
		// str3 == str5 的值是True 还是False呢？ True.
		// 在写代码的时候，一般不要 String str2 = new String("ABC");

		// 当调用 intern 方法时，如果池已经包含一个等于此 String 对象的
		// 字符串（该对象由 equals(Object) 方法确定），则返回池中的字符串。否则，将此 String 对象添加到池中，并且返回此
		// String 对象的引用。
		// String a = "ABC";
		// String b="AB";
		// String c=b+"C";
		// System.out.println(a==c); false
		// a和b都是字符串常量所以在编译期就被确定了！
		// 而c中有个b是引用不是字符串常量所以不会在编译期确定。
		// 而String是final的！所以在b+"c"的时候实际上是新创建了一个对象，然后在把新创建对象的引用传给c.
		// String s = "ddd";//首先是不可继承，大小一旦申请不可更改 ，字符串池
		// String s1 = new String("ddd");//字符串两种赋值方式，如果是new出来的
		// 对字符串进行拼接操作，也就是做"+"运算的时候，分2中情况：
		//
		// i.表达式右边是纯字符串常量，那么存放在栈里面。
		//
		// ii.表达式右边如果存在字符串引用，也就是字符串对象的句柄，那么就存放在堆里面。
		// String s1=new String("kvill");
		// String s2=s1.intern();
		// System.out.println( s1==s2 ); //s1=s1.intern()
		// System.out.println( s1+" "+s2 );
		// System.out.println( s2==s1.intern() );
		// String str1 = "aaa";
		// String str2 = "bbb";
		// String str3 = "aaabbb";
		// String str4 = str1 + str2;
		// String str5 = "aaa" + "bbb";
		// System.out.println(str3 == str4); // false
		// System.out.println(str3 == str4.intern()); // true
		// System.out.println(str3 == str5);// true

		// 常见的String构造器
		// String()
		// String(CharSequence s)
		// String继承CharSequence接口，StringBuffer和StringBuilder也是继承于它
		// String(byte[] bytes)
		// String(byte[] bytes, String charsetName) new
		// String(str.getBytes("iso8859-1"),"utf-8");
		// String(byte[] bytes, int offset, int length) 在流读取字符串的时候用的多
		// String(char[] value) //String本来就是char数组组成的
		// String(char[] value, int offset, int count) 截取字符数组
		String str = "asfassfa97f";
		// 常用方法
		// indexOf()
		System.out.println(str.indexOf("a"));
		System.out.println(str.indexOf("fa"));// 从左往右找单个或者多个字符，返回下标，下标从0开始
		System.out.println(str.indexOf("fa", 4));// 从第5位开始往右找单个或者多个字符，返回下标
		System.out.println(str.indexOf(100));// 100表示ascii中对应的值
		System.out.println(str.indexOf(100, 2));
		// lastIndexOf(char[], int, int, char[], int, int, int)
		System.out.println(str.lastIndexOf("a"));
		System.out.println(str.lastIndexOf("fa"));// 从右往左找单个或者多个字符，返回下标，下标从0开始
		System.out.println(str.lastIndexOf("fa", 4));// 从第5位开始往左找单个或者多个字符，返回下标
		System.out.println(str.lastIndexOf(100));// 100表示asicc中对应的值
		System.out.println(str.lastIndexOf(100, 2));
		// valueOf(boolean)
		System.out.println(String.valueOf(12));
		System.out.println(String.valueOf(12f));
		System.out.println(String.valueOf(12D));
		System.out.println(String.valueOf('中'));
		System.out.println(String.valueOf(new Date()));
		// charAt(int)
		System.out.println(str.charAt(3));
		// concat(String)
		String str1 = "33";
		String str2 = "44";
		String str3 = "3344";
		String str4 = str1.concat(str2);
		String str5 = str1 + str2;
		System.out.println(str3 == str4);
		System.out.println(str5 == str4);
		// contains(CharSequence)//String继承CharSequence接口，StringBuffer和StringBuilder也是继承于它
		System.out.println(str.contains(new StringBuffer("fa")));
		// endsWith(String)
		System.out.println(str.endsWith("a"));// 后缀是以参数结尾的吗
		// equals(Object)
		System.out.println(str2.equals(str1));// 比较值
		// getBytes()
		System.out.println(Arrays.toString(str.getBytes()));// 本方法将返回该操作系统默认的编码格式的字节数组
		System.out.println(new String("撒的发生".getBytes("UTF-8"), "UTF-8"));

		System.out.println((char) 20013);
		System.out.println((long) '中');
		System.out.println('中' > 'a');
		// byte 是字节数据类型 ，是有符号型的，占1 个字节；大小范围为-128—127 。
		// char 是字符数据类型 ，是无符号型的，占2字节(Unicode码 ）；大小范围 是0—65535
		// ；char是一个16位二进制的Unicode字符，JAVA用char来表示一个字符 。
		// 1,char可以表示中文字符,byte不可以;
		// 2,char可以表示一个整数,但不能带符号,只能是正数,范围是0-65535;byte有符号型整数,范围是-128-127;

		// isEmpty()
		System.out.println(str.isEmpty());
		// length()
		System.out.println(str.length());
		// replace(char, char)
		System.out.println("1234567".replace('1', '0'));
		System.out.println("1234567".replace(new String("3"), new String("33")));
		System.out.println("1234567".replace(new StringBuffer("3"), new StringBuffer("33")));
		System.out.println("1234567".replace(new StringBuilder("3"), new StringBuilder("33")));
		// split(String)
		System.out.println(Arrays.toString("192:168:1:1".split(":")));
		System.out.println(Arrays.toString("...192.168.1.1...s...".split("\\.")));// .比较特殊，split误以为是正则表达式
		System.out.println(Arrays.toString("192.168.1.1".split("\\.", 3)));// 3表示分成几份
		System.out.println(Arrays.toString("...192.168.1.1...s...".split("\\.", 100)));// 如果超过最多份数，就该是多少就是多少
		System.out.println(Arrays.toString("...192.168.1.1...s...".split("\\.", 0)));// 如果小于1份，也按split（String regex）算

		// startsWith(String)
		System.out.println("aia.avi".startsWith("a"));
		System.out.println("ai.avi".startsWith("a", 2));
		// substring(int)
		System.out.println("asdfas".substring(1));
		System.out.println("asdfas".substring(1, 2));
		// toLowerCase()
		System.out.println("as3dfFDSa".toLowerCase());
		System.out.println("asdf~！@#￥%……&*（）——+-Dasd阿萨德SFDSa".toLowerCase(Locale.ITALIAN));
		// toUpperCase()
		System.out.println("aasdf".toUpperCase());
		System.out.println("aasdf".toUpperCase(Locale.CANADA));
		// trim()
		System.out.println("  asdf s fa s df as df ".trim());// 只能去掉两边的空格
		System.out.println("  asdf s fa s df as df ".replace(" ", ""));// 去掉所有的空格
		System.out.println("  asdf s fa s df as df ".replaceAll(" ", ""));// 去掉所有的空格
		System.out.println(Arrays.toString(str.toCharArray()));
		System.out.println("---------------StringBuffer--------------------");
		//StringBuffer的append方法效率比String的"+"拼接效率高的多
		StringBuffer buffer = new StringBuffer();

		// append(基本类型/Object/CharSequence)
		buffer.append(23);
		buffer.append("sd");
		buffer.append('3');
		// delete(int,int)
		System.out.println(buffer.delete(0, 2));
		// deleteCharAt(int)
		System.out.println(buffer.deleteCharAt(0));
		// insert(iint,基本类型/Object/CharSequence)
		System.out.println(buffer.insert(1, "asdf"));
		// reverse()
		System.out.println(buffer.reverse());
		// setCharAt(int, char)
		buffer.setCharAt(1, '中');
		System.out.println(buffer);
		System.out.println("---------------StringBuilder--------------------");

		// StringBuilder与StringBuffer类似，只不过StringBuffer是线程安全的
		
		System.out.println("---------------练习题--------------------");

//		1."2323333asdfasdfashadfasdfasdf"，排序。
//		2."asdfasdfahaDFSDFsdfgasGTHDRdhfsdghyjergDSDFHv",大写转小写，小写转大写
//		3."adasdhasdfm asd fa sd fgas dg asdg a d fa sdg  ",去掉所有的空格
//		4."asdfjavaafajavasdfajavasdgasdfasjavadf",找出含有多少个java
		
		String s = "2323333asdfasdfashadfasdfasdf";
		char[] s1 = s.toCharArray();
		Arrays.sort(s1);
		System.out.println(s1);
		
		String string = "asdfasdfahaDFSDFsdfgasGTHDRdhfsdghyjergDSDFHv";
		char[] strings = string.toCharArray();
		for (char c : strings) {
			if(c<='z'&&c>='a'){
				c = (char) (c-32);
			}else if(c<='Z'&&c>='A'){
				c = (char) (c+32);
			}
			
			System.out.print(c);
		}
		System.out.println();
		String string1 = "adasdhasdfm asd fa sd fgas dg asdg a d fa sdg  ";
		string1= string1.replace(" ", "");
		System.out.println(string1);
		
		String string2 = "asdjavafasdfasjavadf";
		int index = 0;
		int count = 0;
		while(true) {
			int a= string2.indexOf("java", index);
			if(a>-1){
				count++;
				index = a;
			}else{
				break;
			}
			index ++;
			
		}
		System.out.println(count);
	}
}
