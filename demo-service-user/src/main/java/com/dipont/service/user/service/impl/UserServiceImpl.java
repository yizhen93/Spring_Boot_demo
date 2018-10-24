package com.dipont.service.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipont.api.bo.UserBO;
import com.dipont.api.entity.UserEntity;
import com.dipont.common.exception.NotContentException;
import com.dipont.service.user.dao.UserDao;
import com.dipont.service.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public List<UserBO> getUsers(int state) throws NotContentException {
        List<UserEntity> userEntities = userDao.selectUserByState(state);
        if (userEntities == null || userEntities.size() == 0) {
            throw new NotContentException();
        }
        List<UserBO> userBos = new ArrayList();//translateUserEntitiesToUserBo(userEntities);
        userEntities.forEach(mapper -> {
        		UserBO userBo = new UserBO();
        		BeanUtils.copyProperties(mapper, userBo);
        		userBos.add(userBo);
        	});
        return userBos;
    }

    private List<UserBO> translateUserEntitiesToUserBo(List<UserEntity> userEntities) {
        List<UserBO> userBos = new ArrayList();
        if (userEntities != null && !userEntities.isEmpty()) {
            for (UserEntity userEntity : userEntities) {
                UserBO userBo = new UserBO();
                userBo.setId(userEntity.getId());
                userBo.setUserName(userEntity.getUserName());
                userBo.setState(userEntity.getState());
                userBos.add(userBo);
            }
        }
        return userBos;
    }
}
