package com.wangle.Net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test06 {
	
	//�봫�ļ���ԭ�����̣��ռ��д���������ظ��ģ���md5���ܺ󣨾�����ν��BT���ӣ������ж��Ƿ��ظ���������Ĳ����ļ�����md5ֻ���Լ��ܲ����Խ��ܣ����ֲ����ļ��ķ�ʽ��Ҳ������ɨ�Ƶȣ�
	//��ôʵ���봫�أ�������Ҫ���ļ��ڱ��˿ռ�����Բ鵽����ô������ֻ��Ҫ��������ӣ�ָ���Ǹ��ļ������ˣ�����Ŀռ����ٲ�������ļ��١�
	//һЩ���̣���첥�ͱ���Ӱ����Ϊ�˸���������ѹ����ǿ��Ҫ���������ؿͻ��ˣ�����ͻ��˿����ǵ����������ģ������Էֵ���������ѹ����������������������е�ʱ�򣬸������ͻ��˹������ݺ����硣
	
	public static void main(String[] args) throws Exception {
		//HttpЭ�飬������ҳ����Ӧ�ã���������
//		�ؼ�Ҫ�أ�����˵�����ͷ����Ӧ�˵���Ӧͷ
//		����socket�ǿ���ʵ�ֵģ�ֻҪ�����ʱ��������������ϸ���������ͷ�����ˡ�
//		��java�У��и�ר�ŷ�����ҳ���࣬URLConnection��URL
		
		URL url = new URL("http://www.kaige123.com");
		URLConnection conn = url.openConnection();
		conn.connect();
		Map<String, List<String>> fields = conn.getHeaderFields();
		Set<String> keySet = fields.keySet();
		for (String string : keySet) {
			System.out.print(string+"=");
			System.out.print(fields.get(string));
			System.out.println();
		}
		
		conn.setDoOutput(true);
	}

}
