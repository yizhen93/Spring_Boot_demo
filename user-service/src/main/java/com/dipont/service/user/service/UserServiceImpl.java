package com.dipont.service.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipont.common.redis.RedisService;
import com.dipont.service.api.UserService;
import com.dipont.service.bo.UserBO;
import com.dipont.service.entity.UserEntity;
import com.dipont.service.user.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisService redisService;
    
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

	@Override
	public String getRedisName() {
		String result = redisService.get("redis").toString();
		return result;
	}

	@Override
	public long addUser(UserBO user) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		return userDao.save(userEntity).getId();
	}
}
