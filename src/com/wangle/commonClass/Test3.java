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
 * @�� ���� Test2 @���������� TODO @������Ϣ�� wangle @����ʱ�䣺 2019��4��28������10:22:51 @�޸ı�ע��
 */
public class Test3 {
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
		Integer c = 128;//���ַ�ʽ��ֵֻ����-128~127����ͨ��valueOf����ֵ�ã���˼���ڳ���������-128~127�������������������������Χ�ڣ��ʹӳ�������ȡ�����Ǿ�new
		//Integer��valueOf����Դ��
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
		System.out.println(Integer.parseInt("121213"));//Ĭ����д������10����
//		System.out.println(Integer.parseInt("1212F3"));//���治�ܴ��ڷ�int���ַ�
//		System.out.println(Integer.parseInt("12362374276345612374"));//̫��Ҳ����
		
		//��������ת����10������parseInt����valueOf
		System.out.println(Integer.parseInt("10011",2));//2����ת��10����
		System.out.println(Integer.valueOf("10011",2));//2����ת��10����
		System.out.println(Integer.parseInt("25676",8));//8����ת��10����
		System.out.println(Integer.valueOf("25676",8));//8����ת��10����
		System.out.println(Integer.parseInt("23D", 16));//16����ת��10����
		System.out.println(Integer.valueOf("23D", 16));//16����ת��10����
		System.out.println(Integer.parseInt("23D", 32));//32����ת��10����
		System.out.println(Integer.valueOf("23D", 32));//32����ת��10����
		System.out.println("_______________________");
		//10����ת����������
		System.out.println(Integer.toBinaryString(123));//10����ת��2����
		System.out.println(Integer.toOctalString(128));//10����ת��8����
		System.out.println(Integer.toHexString(123));//10����ת��16����
		System.out.println(Integer.toString(31, 32));//10����ת��32����
		System.out.println(Integer.toString(128, 8));
		
		System.out.println("--------------------System------------------");
		//��ȡ��������getenv
		System.out.println(System.getenv("path"));
		
		System.out.println(System.getenv("windir"));

		System.out.println(System.getenv("classpath"));
		//��ȡϵͳ����
		System.out.println(System.getProperty("os.name"));
		
		//��ӡ����ϵͳ����
		Set<Object> keySet = System.getProperties().keySet();
		for (Object string : keySet) {
			System.out.println(string+"="+System.getProperty(string.toString()));
		}
		//����
		String str3= "sdfsdf"+System.lineSeparator()+"sdfsdf";
		System.out.println(str3);
		//����
//		int i = 0;
//		while(true){
//			System.out.println((char)System.in.read());
//			if(i==100){
//				break;
//			}
//		}
		//����2
//		System.out.print("����");
//		  Scanner scan = new Scanner(System.in);
//		  String read = scan.nextLine();
//		  System.out.println("�������ݣ�"+read); 
		  
		 //����3
//		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
//		  //java.io.InputStreamReader�̳���Reader��
//		  String read2 = null;
//		  System.out.print("�������ݣ�");
//		  try {
//		   read2 = br.readLine();
//		  } catch (IOException e3) {
//		   e3.printStackTrace();
//		  }
//		  System.out.println("�������ݣ�"+read2); 
		  //����4
//		 BufferedInputStream input = new BufferedInputStream(System.in);
//		 byte[] b3 =new byte[100];
//		int red =  input.read(b3);
//		System.out.println(new String(b3,0,red));
		System.out.println("=================Runtime==============");
		//����ģʽ,ִ��dos����
		Runtime runtime = Runtime.getRuntime();
//		runtime.exec("cmd /c start http://www.baidu.com");
		//runtime.exec("cmd /c start D:\\��ѶQQ\\QQ\\Bin\\QQScLauncher.exe");
		
	}
}
