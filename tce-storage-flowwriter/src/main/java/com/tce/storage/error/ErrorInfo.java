package com.tce.storage.error;

public class ErrorInfo {

	public static final Integer OK = 0;
	public static final Integer ERROR = -1;


	private Integer code;
	private String message;
	private String url;
	private Boolean status;

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public static Integer getOk() {
		return OK;
	}
	public static Integer getError() {
		return ERROR;
	}



	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}




	public ErrorInfo(Integer code, String message, String url, Boolean status) {
		super();
		this.code = code;
		this.message = message;
		this.url = url;
		this.status = status;
	}
	public ErrorInfo() {
		super();
	}
	@Override
	public String toString() {
		return "ErrorInfo [code=" + code + ", message=" + message + ", url=" + url + ",  status="
				+ status + "]";
	}




}
