package com.wangle.Net;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test03 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ServerSocket serversocket = new ServerSocket(8989);//���ط��ʺ���������
		while(true){//���ǵ��̣߳�����ͻ���һ����ʵ�ʱ�򣬻�ܿ�
			Socket socket = serversocket.accept();
			
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			
			byte[] b = new byte[1024];
			input.read(b);
			System.out.println(new String(b));
			
			
			Thread.sleep(5000);
			FileInputStream inputStream = new FileInputStream("F:\\����\\������.png");
			byte[] b2 = new byte[1024];
			int len = 0;
			while((len = inputStream.read(b2))!=-1){
				output.write(b2,0,len);
			}
			
			output.close();
			input.close();
		}
		
	}

}
