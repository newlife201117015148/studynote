package com.wangle.Net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test02 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		//serversocket/socket
		
		// serversocket:获取socket对象，是用于连接服务器的socket对象。
		// socket：自己创建的socket对象。那就是客户端。
		
		
//		socket----------------------------------------->socket
		
//		客户端socket（服务器ip和端口）--------------------------->服务端serversocket，获取socket对象
//		两个socket分别产生in和out流
//		ServerSocket serversocket = new ServerSocket(8989);//本地访问和外网访问
//		ServerSocket serversocket = new ServerSocket(8989,0,InetAddress.getByName("192.168.1.2"));//外网访问
		ServerSocket serversocket = new ServerSocket(8989,0,InetAddress.getByName("127.0.0.1"));//本地访问
		Socket socket = serversocket.accept();
		
		InputStream input = socket.getInputStream();
		OutputStream output = socket.getOutputStream();
		
		byte[] b = new byte[1024];
		input.read(b);
		System.out.println(new String(b));
		
		output.write("你好客户端".getBytes());
		output.close();
		input.close();
		
	}

}
