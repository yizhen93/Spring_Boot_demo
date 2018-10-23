package com.dipont.web.core;

public class ResultDTO<T> {
    private String resultCode = "";
    private String resultMessage = "";
    private T result = null;
//    private String resultStatus = "";
    
    public T getResult() {
        return result;
    }
    public String getResultCode() {
        return resultCode;
    }
    public String getResultMessage() {
        return resultMessage;
    }
//    public String getResultStatus() {
//        return resultStatus;
//    }
    public ResultDTO(T data) {
        this.resultCode = "200";
        this.resultMessage = "Ok";
        this.result = data;
    }
    
    public ResultDTO(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }
    
    public ResultDTO(String resultCode, String resultMessage, T data) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.result = data;
    }
}
