package com.wangle.Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test04 implements Runnable{

	private Socket socket;
	
	public Test04(Socket socket) {
		this.socket = socket;
	}
	
	private static void opensocket() throws IOException {
		ServerSocket serversocket = new ServerSocket(8989);
		ExecutorService pool = Executors.newFixedThreadPool(3);
		while(true){
			pool.execute(new Test04(serversocket.accept()));
		}
		
	}
	
	public void run() {
		try {
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			
			byte[] b = new byte[1024];
			input.read(b);
			System.out.println(new String(b));
			Thread.sleep(5000);
			output.write("ÄãºÃ¿Í»§¶Ë".getBytes());
			output.close();
			input.close();
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args) throws IOException {
		Test04.opensocket();
	}

}
