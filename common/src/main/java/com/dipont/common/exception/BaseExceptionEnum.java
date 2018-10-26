package com.dipont.common.exception;

public enum BaseExceptionEnum {
    CODE_404("404", "请求网页不存在!"),
    CODE_204("204", "所查找内容不存在!"),
    CODE_400("400", "请求参数有误!"),
    CODE_500("500", "抱歉!服务器开小差啦，请稍后再试。。"),;
    
    private String errorCode = "";
    private String errorMessage = "";
    
    BaseExceptionEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
