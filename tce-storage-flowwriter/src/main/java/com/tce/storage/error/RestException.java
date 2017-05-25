package com.tce.storage.error;

public class RestException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常统一处理类
	 */
	 public RestException(String message) {
	        super(message);
	    }
}
