package com.dipont.common.exception;

public class BadRequestException extends BaseException{
	private static final long serialVersionUID = -2371343183090838204L;

	public BadRequestException() {
        super.add(BaseExceptionEnum.CODE_400);
    }
}
