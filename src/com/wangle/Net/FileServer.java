package com.wangle.Net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileServer implements Runnable {

	private Socket socket;

	public FileServer(Socket socket) {
		this.socket = socket;
	}

	private static ServerSocket serversocket = null;
	public static void openServer(final int port) throws Exception {

		new Thread(){
			public void run() {
				try {
					if(serversocket != null && !serversocket.isClosed()){
						closeServer();
					}
					serversocket = new ServerSocket(port);
					ExecutorService pool = Executors.newFixedThreadPool(10);
					while(true){
						pool.execute(new FileServer(serversocket.accept()));
					}
				}catch(BindException e){
					javax.swing.JOptionPane.showMessageDialog(null, "端口被占用");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}.start();
	}

	public static void closeServer(){
		try {
			serversocket.close();
		} catch (Exception e) {
		}
	
	}

	public void run() {
		try {
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			byte[] b= new byte [1000];
			int len = in.read(b);
			String str = new String(b,0,len);
			String[] strs = str.split("\t");
			String filename = strs[0];
			long filesize = Long.parseLong(strs[1]);
			
			int i = javax.swing.JOptionPane.showConfirmDialog(null, socket.getInetAddress().getHostAddress()
					+"对方发送一个文件名称："+filename+"\r\n"+"文件大小："+filesize/1024/1024+"MB\r\n");
			if(i==JOptionPane.OK_OPTION){
				out.write("ok".getBytes());
				out.flush();
				
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showSaveDialog(null);
				
				FileOutputStream outs = new FileOutputStream(new File(chooser.getSelectedFile(),filename));
				
				byte[] bs = new byte[1024*8];
				while((len = in.read(bs))!=-1){
					outs.write(bs, 0, len);
				}
				
				outs.close();
			}else{
				out.write("no".getBytes());
				out.flush();
			}
			
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
