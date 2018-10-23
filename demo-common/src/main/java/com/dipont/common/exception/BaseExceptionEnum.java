package com.dipont.common.exception;

public enum BaseExceptionEnum {
    CODE_404("404", "Not Found!"),
    CODE_204("204", "Not Content!"),
    CODE_400("400", "Bad Request!"),;
    
    private String errorCode = "";
    private String errorMessage = "";
    
    BaseExceptionEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
