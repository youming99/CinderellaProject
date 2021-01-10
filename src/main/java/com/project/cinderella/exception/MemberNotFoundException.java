package com.project.cinderella.exception;

//CRUD 작업 시 발생하는 예외
public class MemberNotFoundException extends RuntimeException{
	
	public MemberNotFoundException(String msg) {
		super(msg);
	}
	public MemberNotFoundException(String msg, Throwable e) {
		super(msg, e);
	}

}
