package com.wangle.commonClass;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @�� ���� Test1 @���������� ��Stirng StringBuffer StringBuilder������ϰ @������Ϣ��
 *    wangle @����ʱ�䣺 2019��4��28������1:09:14 @�޸ı�ע��
 */
public class Test1 {
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
	//���죺
//	Class ����
//	File �ļ���
//	Timer ʱ����
	public static void main(String[] args) throws UnsupportedEncodingException {
		// String str1="ABC" ���ܴ���һ��������߲������������"ABC"����ַ�����java String���ﲻ���ڣ�
		// ����java String�ش������һ��String����("ABC").����Ѿ����ڣ�str1ֱ��reference to
		// ���String����Ķ���
		// String str2 = new String("ABC") ���ٴ���һ������Ҳ������������Ϊ�õ�new �ؼ��֣�����heap����һ��
		// str2 ��String ����
		// ����value �� "ABC".ͬʱ�����"ABC"����ַ�����java String���ﲻ���ڣ�����java
		// String�ش������һ��String����("ABC").
		// String str3 = "ABC";
		// String str4 = "ABC";
		// String str5 = "A" + "BC";
		// str3 == str4 ��ֵ��True ����False�أ� True.
		// str3 == str5 ��ֵ��True ����False�أ� True.
		// ��д�����ʱ��һ�㲻Ҫ String str2 = new String("ABC");

		// ������ intern ����ʱ��������Ѿ�����һ�����ڴ� String �����
		// �ַ������ö����� equals(Object) ����ȷ�������򷵻س��е��ַ��������򣬽��� String ������ӵ����У����ҷ��ش�
		// String ��������á�
		// String a = "ABC";
		// String b="AB";
		// String c=b+"C";
		// System.out.println(a==c); false
		// a��b�����ַ������������ڱ����ھͱ�ȷ���ˣ�
		// ��c���и�b�����ò����ַ����������Բ����ڱ�����ȷ����
		// ��String��final�ģ�������b+"c"��ʱ��ʵ�������´�����һ������Ȼ���ڰ��´�����������ô���c.
		// String s = "ddd";//�����ǲ��ɼ̳У���Сһ�����벻�ɸ��� ���ַ�����
		// String s1 = new String("ddd");//�ַ������ָ�ֵ��ʽ�������new������
		// ���ַ�������ƴ�Ӳ�����Ҳ������"+"�����ʱ�򣬷�2�������
		//
		// i.���ʽ�ұ��Ǵ��ַ�����������ô�����ջ���档
		//
		// ii.���ʽ�ұ���������ַ������ã�Ҳ�����ַ�������ľ������ô�ʹ���ڶ����档
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

		// ������String������
		// String()
		// String(CharSequence s)
		// String�̳�CharSequence�ӿڣ�StringBuffer��StringBuilderҲ�Ǽ̳�����
		// String(byte[] bytes)
		// String(byte[] bytes, String charsetName) new
		// String(str.getBytes("iso8859-1"),"utf-8");
		// String(byte[] bytes, int offset, int length) ������ȡ�ַ�����ʱ���õĶ�
		// String(char[] value) //String��������char������ɵ�
		// String(char[] value, int offset, int count) ��ȡ�ַ�����
		String str = "asfassfa97f";
		// ���÷���
		// indexOf()
		System.out.println(str.indexOf("a"));
		System.out.println(str.indexOf("fa"));// ���������ҵ������߶���ַ��������±꣬�±��0��ʼ
		System.out.println(str.indexOf("fa", 4));// �ӵ�5λ��ʼ�����ҵ������߶���ַ��������±�
		System.out.println(str.indexOf(100));// 100��ʾascii�ж�Ӧ��ֵ
		System.out.println(str.indexOf(100, 2));
		// lastIndexOf(char[], int, int, char[], int, int, int)
		System.out.println(str.lastIndexOf("a"));
		System.out.println(str.lastIndexOf("fa"));// ���������ҵ������߶���ַ��������±꣬�±��0��ʼ
		System.out.println(str.lastIndexOf("fa", 4));// �ӵ�5λ��ʼ�����ҵ������߶���ַ��������±�
		System.out.println(str.lastIndexOf(100));// 100��ʾasicc�ж�Ӧ��ֵ
		System.out.println(str.lastIndexOf(100, 2));
		// valueOf(boolean)
		System.out.println(String.valueOf(12));
		System.out.println(String.valueOf(12f));
		System.out.println(String.valueOf(12D));
		System.out.println(String.valueOf('��'));
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
		// contains(CharSequence)//String�̳�CharSequence�ӿڣ�StringBuffer��StringBuilderҲ�Ǽ̳�����
		System.out.println(str.contains(new StringBuffer("fa")));
		// endsWith(String)
		System.out.println(str.endsWith("a"));// ��׺���Բ�����β����
		// equals(Object)
		System.out.println(str2.equals(str1));// �Ƚ�ֵ
		// getBytes()
		System.out.println(Arrays.toString(str.getBytes()));// �����������ظò���ϵͳĬ�ϵı����ʽ���ֽ�����
		System.out.println(new String("���ķ���".getBytes("UTF-8"), "UTF-8"));

		System.out.println((char) 20013);
		System.out.println((long) '��');
		System.out.println('��' > 'a');
		// byte ���ֽ��������� �����з����͵ģ�ռ1 ���ֽڣ���С��ΧΪ-128��127 ��
		// char ���ַ��������� �����޷����͵ģ�ռ2�ֽ�(Unicode�� ������С��Χ ��0��65535
		// ��char��һ��16λ�����Ƶ�Unicode�ַ���JAVA��char����ʾһ���ַ� ��
		// 1,char���Ա�ʾ�����ַ�,byte������;
		// 2,char���Ա�ʾһ������,�����ܴ�����,ֻ��������,��Χ��0-65535;byte�з���������,��Χ��-128-127;

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
		System.out.println(Arrays.toString("...192.168.1.1...s...".split("\\.")));// .�Ƚ����⣬split����Ϊ��������ʽ
		System.out.println(Arrays.toString("192.168.1.1".split("\\.", 3)));// 3��ʾ�ֳɼ���
		System.out.println(Arrays.toString("...192.168.1.1...s...".split("\\.", 100)));// ����������������͸��Ƕ��پ��Ƕ���
		System.out.println(Arrays.toString("...192.168.1.1...s...".split("\\.", 0)));// ���С��1�ݣ�Ҳ��split��String regex����

		// startsWith(String)
		System.out.println("aia.avi".startsWith("a"));
		System.out.println("ai.avi".startsWith("a", 2));
		// substring(int)
		System.out.println("asdfas".substring(1));
		System.out.println("asdfas".substring(1, 2));
		// toLowerCase()
		System.out.println("as3dfFDSa".toLowerCase());
		System.out.println("asdf~��@#��%����&*��������+-Dasd������SFDSa".toLowerCase(Locale.ITALIAN));
		// toUpperCase()
		System.out.println("aasdf".toUpperCase());
		System.out.println("aasdf".toUpperCase(Locale.CANADA));
		// trim()
		System.out.println("  asdf s fa s df as df ".trim());// ֻ��ȥ�����ߵĿո�
		System.out.println("  asdf s fa s df as df ".replace(" ", ""));// ȥ�����еĿո�
		System.out.println("  asdf s fa s df as df ".replaceAll(" ", ""));// ȥ�����еĿո�
		System.out.println(Arrays.toString(str.toCharArray()));
		System.out.println("---------------StringBuffer--------------------");
		//StringBuffer��append����Ч�ʱ�String��"+"ƴ��Ч�ʸߵĶ�
		StringBuffer buffer = new StringBuffer();

		// append(��������/Object/CharSequence)
		buffer.append(23);
		buffer.append("sd");
		buffer.append('3');
		// delete(int,int)
		System.out.println(buffer.delete(0, 2));
		// deleteCharAt(int)
		System.out.println(buffer.deleteCharAt(0));
		// insert(iint,��������/Object/CharSequence)
		System.out.println(buffer.insert(1, "asdf"));
		// reverse()
		System.out.println(buffer.reverse());
		// setCharAt(int, char)
		buffer.setCharAt(1, '��');
		System.out.println(buffer);
		System.out.println("---------------StringBuilder--------------------");

		// StringBuilder��StringBuffer���ƣ�ֻ����StringBuffer���̰߳�ȫ��
		
		System.out.println("---------------��ϰ��--------------------");

//		1."2323333asdfasdfashadfasdfasdf"������
//		2."asdfasdfahaDFSDFsdfgasGTHDRdhfsdghyjergDSDFHv",��дתСд��Сдת��д
//		3."adasdhasdfm asd fa sd fgas dg asdg a d fa sdg  ",ȥ�����еĿո�
//		4."asdfjavaafajavasdfajavasdgasdfasjavadf",�ҳ����ж��ٸ�java
		
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
