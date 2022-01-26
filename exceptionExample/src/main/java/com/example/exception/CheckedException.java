package com.example.exception;

import java.io.FileInputStream;
import java.io.IOException;

public class CheckedException {
	public static void main(String[] args) {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("hello.txt");
			int data = fis.read();
			System.out.println((char)data);
		} catch (Exception e) {
			System.out.println("error : "+e);
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
