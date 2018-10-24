package com.dipont.web.core;

public class AbnormalResultDTO extends ResultDTO{
	public AbnormalResultDTO() {
		this.code = "500";
		this.message = "抱歉，内部异常，请稍后再试!";
	}
	
	public AbnormalResultDTO(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
