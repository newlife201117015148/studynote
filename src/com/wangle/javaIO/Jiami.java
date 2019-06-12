package com.wangle.javaIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Jiami extends OutputStream{
	private OutputStream out;
	public Jiami(OutputStream out){
		this.out = out;
	}
	public void write(int b) throws IOException {
		System.out.println(~b);
		out.write(~b);
	}
}
