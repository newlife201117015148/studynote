package com.wangle.commonClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Arrays;
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
		
		//控制键盘、鼠标（左右建，滚轮）
		Robot robot = new Robot();
//		for (int i = 0; i < 1100; i++) {
//			
//			robot.keyPress(KeyEvent.VK_SHIFT);
//			robot.keyPress(KeyEvent.VK_B);
//			robot.keyRelease(KeyEvent.VK_B);
//			robot.keyRelease(KeyEvent.VK_SHIFT);
//		}
		
//		robot.mouseMove(21, 21);
//		robot.mousePress(MouseEvent.BUTTON3_MASK);
//		robot.mouseRelease(MouseEvent.BUTTON3_MASK);
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
		System.out.println(b==d);//true
		System.out.println(c==e);//true
		System.out.println(f==g);//false
		System.out.println("_____________");
		/*总结：
		 * ①、无论如何，Integer与new Integer不会相等。不会经历拆箱过程，因为它们存放内存的位置不一样。（要看具体位置，可以看看这篇文章：点击打开链接）
		 * 
		 * ②、两个都是非new出来的Integer，如果数在-128到127之间，则是true,否则为false。
		 * 
		 * ③、两个都是new出来的,则为false。
		 * 
		 * ④、int和integer(new或非new)比较，都为true，因为会把Integer自动拆箱为int， 其实就是相当于两个int类型比较。
		 */
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
		
		Short la = 3;
		System.out.println("--------------------System------------------");
		//获取环境变量getenv
		System.out.println(System.getenv("path"));
		
		System.out.println(System.getenv("windir"));

		System.out.println(System.getenv("classpath"));
		//获取系统参数
		System.out.println(System.getProperty("os.name"));
		//退出系统
		//System.exit(0);
		//获取时间毫秒数
		System.currentTimeMillis();
		//通知垃圾回收器回收
		System.gc();
		//复制数组
		int[] arr = new int[3];
		System.arraycopy(new int[]{1,2,3}, 0,arr, 0, 3);
		System.out.println(Arrays.toString(arr));
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
		//获取cpu核心数
		System.out.println(runtime.availableProcessors());
		//获取内存剩余空间
		System.out.println(runtime.freeMemory());
		//获取内存最大空间
		System.out.println(runtime.maxMemory());
		// 获取内存总空间
		System.out.println(runtime.totalMemory());
	}
}
