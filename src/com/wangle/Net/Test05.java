package com.wangle.Net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Test05 {

	public static void main(String[] args) throws Exception {

		
		while(true){
			Socket socket = new Socket("192.168.1.2",8989);
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			
			outputStream.write("nihao·þÎñÆ÷".getBytes());
			
			byte[] b = new byte[1024];
			int len = inputStream.read(b);
			System.out.println(new String(b,0,len));
			
			outputStream.close();
			inputStream.close();
			socket.close();
		}
		
		
	}

}
