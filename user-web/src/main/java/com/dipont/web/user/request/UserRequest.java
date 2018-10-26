package com.dipont.web.user.request;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class UserRequest {
    private long id;
    
    @NotEmpty(message = "姓名不能为空")
    private String userName;
    
    @Range(min = 1, max = 3, message = "状态不正确")
    private int state;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String name) {
        this.userName = name;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    
}
