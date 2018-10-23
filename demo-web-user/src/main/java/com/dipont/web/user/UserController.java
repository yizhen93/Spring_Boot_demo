package com.dipont.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dipont.api.bo.UserBO;
import com.dipont.common.exception.NotContentException;
import com.dipont.service.user.service.UserService;
import com.dipont.web.core.BaseController;
import com.dipont.web.core.ResultDTO;

@RestController
public class UserController extends BaseController{
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/hello")
    public String hello() {
        return "hahaha";
    }
    
    @GetMapping(value="/users/{state}")
    public ResultDTO<UserBO> getUsersByState(@PathVariable("state") int state) throws Exception{
//        try {
//            List<UserBO> users = userService.getUsers(state);
//            return new ResultDTO(users);
//        } catch (Exception ex) {
//            return handleException(ex);
//        }
        List<UserBO> users = userService.getUsers(state);
        return new ResultDTO(users);
    }
    
}
