package com.dipont.service.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipont.api.bo.UserBO;
import com.dipont.api.entity.UserEntity;
import com.dipont.service.user.dao.UserDao;
import com.dipont.service.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public List<UserBO> getUsers(int state) {
    	List<UserBO> userBos = new ArrayList<>();
        List<UserEntity> userEntities = userDao.findByState(state);
        if (userEntities != null && userEntities.size() > 0) {
        	userEntities.forEach(mapper -> {
        		UserBO userBo = new UserBO();
        		BeanUtils.copyProperties(mapper, userBo);
        		userBos.add(userBo);
        	});
        }
        
        return userBos;
    }

}
