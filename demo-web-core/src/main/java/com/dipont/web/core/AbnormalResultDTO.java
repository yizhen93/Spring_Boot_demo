package com.dipont.web.core;

import com.dipont.common.exception.BaseExceptionEnum;

public class AbnormalResultDTO extends ResultDTO{
	public AbnormalResultDTO() {
		this.code = BaseExceptionEnum.CODE_500.getErrorCode();
		this.message = BaseExceptionEnum.CODE_500.getErrorMessage();
	}
	
	public AbnormalResultDTO(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
