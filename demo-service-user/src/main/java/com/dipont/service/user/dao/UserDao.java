package com.dipont.service.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.dipont.api.entity.UserEntity;
import com.dipont.service.dao.BaseDao;

public interface UserDao extends BaseDao<UserEntity> {
    
    @Select("select * from user where state = #{state}")
    public List<UserEntity> selectUserByState(int state);
}
