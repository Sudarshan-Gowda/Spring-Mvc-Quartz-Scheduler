package com.star.sud.framework.service.email;

public class EmailStatus {

	public enum STATUS {
		SUCCESS, FAILED
	}

	private STATUS status;
	private String message;
	private String exception;

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

}
