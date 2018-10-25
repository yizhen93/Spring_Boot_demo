package com.dipont.common.exception;

public class BaseRuntimeException extends RuntimeException{
	private static final long serialVersionUID = 8456966172362293636L;
	
	protected String errorCode = "";
    protected String errorMessage = "";
    
    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public BaseRuntimeException add(BaseExceptionEnum data) {
        this.errorCode = data.getErrorCode();
        this.errorMessage = data.getErrorMessage();
        return this;
    }
}
