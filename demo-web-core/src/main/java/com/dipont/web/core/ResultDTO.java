package com.dipont.web.core;

public abstract class ResultDTO {
	protected String code = "";
	protected String message = "";

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
