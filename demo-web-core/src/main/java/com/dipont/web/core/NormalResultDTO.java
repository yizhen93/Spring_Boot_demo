package com.dipont.web.core;

public class NormalResultDTO<T> extends ResultDTO{
    private T result = null;
    
    public T getResult() {
        return result;
    }
    public NormalResultDTO(T data) {
        this.code = "200";
        this.message = "Ok";
        this.result = data;
    }
    
    public NormalResultDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public NormalResultDTO(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }
}
