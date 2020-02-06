package com.seva.user.exception;

public class UserNotFoundException extends UserServiceException{
	
	private static final long serialVersionUID = 1L;
	private String errorCode = "Severe";
	private String errorLevel = "08" ;
	private String errorMessage = "Requested User was not found !!";
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorLevel() {
		return errorLevel;
	}
	public void setErrorLevel(String errorLevel) {
		this.errorLevel = errorLevel;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
