package com.wangle.commonClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;

/**
 * @类 名： Test2 @功能描述： TODO @作者信息： wangle @创建时间： 2019年4月28日上午10:22:51 @修改备注：
 */
public class Test3 {
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
		System.out.println("---------------------Robot----------------");
		Robot robot = new Robot();
//		for (int i = 0; i < 1100; i++) {
//			
//			robot.keyPress(KeyEvent.VK_SHIFT);
//			robot.keyPress(KeyEvent.VK_B);
//			robot.keyRelease(KeyEvent.VK_B);
//			robot.keyRelease(KeyEvent.VK_SHIFT);
//		}
		
//		robot.mouseMove(21, 21);
		
//		robot.mousePress(MouseEvent.BUTTON1_MASK);
//		robot.mouseRelease(MouseEvent.BUTTON1_MASK);
//		for (int i = 0; i < 10; i++) {
//			Thread.sleep(100);
//			robot.mouseWheel(-10);
//			robot.mouseWheel(10);
//		}
		
		System.out.println("-------------Integer-------------");
		
		int a = 21;
		Integer b = 33;
		Integer c = 128;//这种方式赋值只能在-128~127，是通过valueOf来给值得，意思是在常量池中有-128~127的数，如果你申请的数在这个范围内，就从池子里面取，不是就new
		//Integer的valueOf方法源码
//		 public static Integer valueOf(int i) {
//		        assert IntegerCache.high >= 127;
//		        if (i >= IntegerCache.low && i <= IntegerCache.high)
//		            return IntegerCache.cache[i + (-IntegerCache.low)];
//		        return new Integer(i);
//		    }
		
		int d = 33;
		int e = 128;
		Integer f = new Integer(127);
		Integer g = 127;
		System.out.println(b==d);
		System.out.println(c==e);
		System.out.println(f==g);
		System.out.println("_____________");
		System.out.println(Integer.parseInt("121213"));//默认填写内容是10进制
//		System.out.println(Integer.parseInt("1212F3"));//里面不能存在非int的字符
//		System.out.println(Integer.parseInt("12362374276345612374"));//太大也不行
		
		//其它进制转换成10进制用parseInt或者valueOf
		System.out.println(Integer.parseInt("10011",2));//2进制转成10进制
		System.out.println(Integer.valueOf("10011",2));//2进制转成10进制
		System.out.println(Integer.parseInt("25676",8));//8进制转成10进制
		System.out.println(Integer.valueOf("25676",8));//8进制转成10进制
		System.out.println(Integer.parseInt("23D", 16));//16进制转成10进制
		System.out.println(Integer.valueOf("23D", 16));//16进制转成10进制
		System.out.println(Integer.parseInt("23D", 32));//32进制转成10进制
		System.out.println(Integer.valueOf("23D", 32));//32进制转成10进制
		System.out.println("_______________________");
		//10进制转成其它进制
		System.out.println(Integer.toBinaryString(123));//10进制转成2进制
		System.out.println(Integer.toOctalString(128));//10进制转成8进制
		System.out.println(Integer.toHexString(123));//10进制转成16进制
		System.out.println(Integer.toString(31, 32));//10进制转成32进制
		System.out.println(Integer.toString(128, 8));
		
		System.out.println("--------------------System------------------");
		//获取环境变量getenv
		System.out.println(System.getenv("path"));
		
		System.out.println(System.getenv("windir"));

		System.out.println(System.getenv("classpath"));
		//获取系统参数
		System.out.println(System.getProperty("os.name"));
		
		//打印所有系统参数
		Set<Object> keySet = System.getProperties().keySet();
		for (Object string : keySet) {
			System.out.println(string+"="+System.getProperty(string.toString()));
		}
		//换行
		String str3= "sdfsdf"+System.lineSeparator()+"sdfsdf";
		System.out.println(str3);
		//输入
//		int i = 0;
//		while(true){
//			System.out.println((char)System.in.read());
//			if(i==100){
//				break;
//			}
//		}
		//输入2
//		System.out.print("输入");
//		  Scanner scan = new Scanner(System.in);
//		  String read = scan.nextLine();
//		  System.out.println("输入数据："+read); 
		  
		 //输入3
//		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
//		  //java.io.InputStreamReader继承了Reader类
//		  String read2 = null;
//		  System.out.print("输入数据：");
//		  try {
//		   read2 = br.readLine();
//		  } catch (IOException e3) {
//		   e3.printStackTrace();
//		  }
//		  System.out.println("输入数据："+read2); 
		  //输入4
//		 BufferedInputStream input = new BufferedInputStream(System.in);
//		 byte[] b3 =new byte[100];
//		int red =  input.read(b3);
//		System.out.println(new String(b3,0,red));
		System.out.println("=================Runtime==============");
		//单例模式,执行dos命令
		Runtime runtime = Runtime.getRuntime();
//		runtime.exec("cmd /c start http://www.baidu.com");
		//runtime.exec("cmd /c start D:\\腾讯QQ\\QQ\\Bin\\QQScLauncher.exe");
		
	}
}
