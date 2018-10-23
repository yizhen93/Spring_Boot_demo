package com.dipont.common.exception;

public class BadRequestException extends BaseException{
    public BadRequestException() {
        super.add(BaseExceptionEnum.CODE_400);
    }
}
