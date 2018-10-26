package com.dipont.web.core;

public abstract class ResultDTO {
	protected String status = "";
	protected String message = "";

    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
}
