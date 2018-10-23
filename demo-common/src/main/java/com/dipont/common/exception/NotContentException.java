package com.dipont.common.exception;

public class NotContentException extends BaseException {
    public NotContentException() {
        super.add(BaseExceptionEnum.CODE_204);
    }
}
