package com.dipont.web.user.response;


import com.dipont.web.response.BaseReponse;

public class UserDetailResponse extends BaseReponse {
    
    private long id;
    
    private String name;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
