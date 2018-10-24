package com.dipont.common.exception;

public class NotFoundException extends BaseException{
	private static final long serialVersionUID = -582152929249135788L;

	public NotFoundException() {
        super.add(BaseExceptionEnum.CODE_404);
    }
}
