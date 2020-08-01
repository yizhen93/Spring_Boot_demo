package com.dipont.web.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dipont.common.exception.BaseExceptionEnum;
import com.dipont.service.api.UserService;
import com.dipont.service.bo.UserBO;
import com.dipont.web.core.BaseController;
import com.dipont.web.core.NormalResultDTO;
import com.dipont.web.core.ResultDTO;
import com.dipont.web.user.request.UserRequest;
import com.dipont.web.user.response.UserDetailReponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value="/users", tags = "用户模块")
@RestController
@RequestMapping("/users")
public class UserController extends BaseController{
    
    @Autowired
    private UserService userService;
    
    @ApiOperation(value="hello", notes = "测试swagger")
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
    
    @PostMapping
    @ApiOperation(value="添加用户信息", notes = "添加用户信息")
    @ApiImplicitParam(name="user", value="User", required = true, dataType = "UserRequest")
    public ResultDTO addUser(@RequestBody @Validated UserRequest user, BindingResult bindingResult) {
    	ResultDTO result = null;
    	if (bindingResult.hasErrors()) {
    		result = new NormalResultDTO<List<FieldError>>(BaseExceptionEnum.CODE_400, bindingResult.getFieldErrors());
    	} else {
        	UserBO userBo = new UserBO();
        	BeanUtils.copyProperties(user, userBo);
        	result = new NormalResultDTO<Long>(userService.addUser(userBo));
    	}
    	return result;
    }
    
    @GetMapping(value="/redis")
    public ResultDTO getRedisName() {
    	String result = userService.getRedisName();
    	return new NormalResultDTO<String>(result);
    }
}
