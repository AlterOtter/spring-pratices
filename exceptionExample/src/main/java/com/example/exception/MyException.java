package com.example.exception;

public class MyException extends Exception{
	public MyException(String Message) {
		super(Message);
	}
	
	public MyException() {
		super("MyException");
	}
}
