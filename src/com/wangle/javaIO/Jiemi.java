package com.wangle.javaIO;

import java.io.IOException;
import java.io.InputStream;

public class Jiemi extends InputStream{

	private InputStream inputStream;
	
	public Jiemi(InputStream inputStream){
		this.inputStream = inputStream;
	}

	public int read() throws IOException {
		
		return inputStream.read();
	}
	public int read(byte[] b) throws IOException {
		int len = inputStream.read(b);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) ~b[i];
		}
		
		return len;
	}
}
