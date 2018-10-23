package com.dipont.service.user.service;

import java.util.List;

import com.dipont.api.bo.UserBO;
import com.dipont.common.exception.NotContentException;

public interface UserService {
    List<UserBO> getUsers(int state) throws NotContentException;
}
