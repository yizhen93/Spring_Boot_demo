package com.dipont.service.user.service;

import java.util.List;

import com.dipont.api.bo.UserBO;

public interface UserService {
    List<UserBO> getUsers(int state);
    String getRedisName();
}
