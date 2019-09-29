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
	
	//秒传文件的原理：网盘，空间中大多数据是重复的，用md5加密后（就是所谓的BT种子）可以判断是否重复，不管你改不改文件名，md5只可以加密不可以解密，这种查找文件的方式，也可用于扫黄等，
	//怎么实现秒传呢，首先你要的文件在别人空间里可以查到，那么服务器只需要给你个链接，指向那个文件就行了，但你的空间会减少并不是真的减少。
	//一些厂商（如快播和暴风影音）为了给服务器减压，会强烈要求让你下载客户端，这个客户端可以是当作服务器的，它可以分担服务器的压力，比如它会在你网络空闲的时候，给其他客户端共享数据和网络。
	
	public static void main(String[] args) throws Exception {
		//Http协议，用于网页请求，应用：网络爬虫
//		关键要素：请求端的请求头和响应端的响应头
//		利用socket是可以实现的，只要请求的时候给服务器发送严格规则的请求头就行了。
//		在java中，有个专门访问网页的类，URLConnection和URL
		
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
