package com.dipont.common.exception;

public class NotFoundException extends BaseException{
    public NotFoundException() {
        super.add(BaseExceptionEnum.CODE_404);
    }
}
