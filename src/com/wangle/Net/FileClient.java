package com.wangle.Net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JProgressBar;

public class FileClient implements Runnable {
	private String ip;
	private int port;
	private String filename;
	private JProgressBar progressBar;

	public FileClient(String ip, int port, String filename, JProgressBar progressBar) {
		this.ip = ip;
		this.port = port;
		this.filename = filename;
		this.progressBar = progressBar;
	}

	public void run() {
		try {
			File file = new File(filename);
			Socket socket = new Socket(ip,port);
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			String str = new String(file.getName() +"\t"+file.length());
			out.write(str.getBytes());
			out.flush();
			
			byte[] b = new byte[1000];
			int len = 0;
			len = in.read(b);
			String re = new String(b,0,len);
			
			progressBar.setMaximum((int)(file.length()/10000));
			int num = 0;
			if(re.equals("ok")){
				FileInputStream fis = new FileInputStream(filename);
				byte[] bs = new byte[1024*8];
				int l = 0;
				while((l = fis.read(bs))!=-1){
					out.write(bs, 0, l);
					out.flush();
					num += l;
					progressBar.setValue(num/10000);
				}
				fis.close();
				javax.swing.JOptionPane.showMessageDialog(null, "发送完毕");
			}else{
				javax.swing.JOptionPane.showMessageDialog(null, "对方拒绝接收你的文件");
			}
			
			out.close();
			in.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
