package com.dipont.common.exception;

public class BaseException extends Exception{
    protected String errorCode = "";
    protected String errorMessage = "";
    
    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public BaseException add(BaseExceptionEnum data) {
        this.errorCode = data.getErrorCode();
        this.errorMessage = data.getErrorMessage();
        return this;
    }
}
