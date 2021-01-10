package com.project.cinderella.exception;

//CRUD 작업 시 발생하는 예외
public class MemberRegistException extends RuntimeException{
	
	public MemberRegistException(String msg) {
		super(msg);
	}
	public MemberRegistException(String msg, Throwable e) {
		super(msg, e);
	}

}
