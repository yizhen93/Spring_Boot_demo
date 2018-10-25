package com.dipont.web.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dipont.api.bo.UserBO;
import com.dipont.service.user.service.UserService;
import com.dipont.web.core.BaseController;
import com.dipont.web.core.NormalResultDTO;
import com.dipont.web.core.ResultDTO;
import com.dipont.web.user.response.UserDetailReponse;


@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/hello")
    public String hello() {
        return "hahaha";
    }
    
    @GetMapping(value="/state/{state}")
    public ResultDTO getUsersByState(@PathVariable("state") int state){
    	List<UserDetailReponse> users = new ArrayList<>();
        List<UserBO> userBos = userService.getUsers(state);
        if (userBos.size() > 0) {
        	userBos.forEach((userBo) -> {
        		UserDetailReponse user = new UserDetailReponse();
        		BeanUtils.copyProperties(userBo, user);
        		users.add(user);
        	});
        }
        return new NormalResultDTO<List<UserDetailReponse>>(users);
    }
    
    @GetMapping(value="/redis")
    public ResultDTO getRedisName() {
    	String result = userService.getRedisName();
    	return new NormalResultDTO<String>(result);
    }
}
