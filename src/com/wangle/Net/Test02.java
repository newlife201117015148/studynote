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
		/*
		 * ServerSocket(int port, int backlog, InetAddress bindAddr) 中的backlog是指等待连接的队列中容纳的最大连接数
		 * 其默认值是50，如果其值小于等于0，就是采用默认值。
		 * 一个新的客户端请求，就会往队列里面增加一个连接，accpet接收一个连接，队列就会减少一个连接。
		 * 
		 * bindAddr 是绑定的本地IP地址
		 */
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
