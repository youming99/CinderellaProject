package com.project.cinderella.exception;

public class OrderSummaryRegistException extends RuntimeException{
	
	public OrderSummaryRegistException(String msg) {
		super(msg);
	}
	public OrderSummaryRegistException(String msg, Throwable e) {
		super(msg, e);
	} 

}
