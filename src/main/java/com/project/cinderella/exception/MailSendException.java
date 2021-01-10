package com.project.cinderella.exception;

//메일 전송 시 발생하는 예외
public class MailSendException extends RuntimeException{
	
	public MailSendException(String msg) {
		super(msg);
	}
	public MailSendException(String msg, Throwable e) {
		super(msg, e);
	}

}
