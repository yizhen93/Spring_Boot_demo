package com.dipont.common.exception;

public class NotContentException extends BaseException {
	private static final long serialVersionUID = 8780776097582329450L;

	public NotContentException() {
        super.add(BaseExceptionEnum.CODE_204);
    }
}
