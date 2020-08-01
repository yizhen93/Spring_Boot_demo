package com.dipont.service.api;

import java.util.List;

import com.dipont.service.bo.UserBO;


public interface UserService {
    List<UserBO> getUsers(int state);
    String getRedisName();
    long addUser(UserBO user);
}
