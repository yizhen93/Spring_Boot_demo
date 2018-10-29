package com.dipont.service.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dipont.service.entity.UserEntity;


public interface UserDao extends JpaRepository<UserEntity, Long> {

	List<UserEntity> findByState(int state);
    
}
