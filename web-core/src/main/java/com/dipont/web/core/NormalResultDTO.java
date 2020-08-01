package com.dipont.web.core;

import com.dipont.common.exception.BaseExceptionEnum;

public class NormalResultDTO<T> extends ResultDTO{
    private T result = null;
    
    public T getResult() {
        return result;
    }
    public NormalResultDTO(T data) {
        this.status = "200";
        this.message = "Ok";
        this.result = data;
    }
    
    public NormalResultDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }
    
    public NormalResultDTO(BaseExceptionEnum baseExceptionEnum, T data) {
        this.status = baseExceptionEnum.getErrorCode();
        this.message = baseExceptionEnum.getErrorMessage();
        this.result = data;
    }
    
    public NormalResultDTO(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.result = data;
    }
}
