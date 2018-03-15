package com.shaw.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaw.cn.entity.User;
import com.shaw.cn.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value="user")  
@Controller  
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
    public UserService userService;  
  
    @RequestMapping(value = "/getUser")  
    @ResponseBody  
    @ApiOperation(value="根据ID获取用户信息",httpMethod="GET",notes="get user by id",response=User.class)  
    public User getUser(@ApiParam(required=true,value="用户ID",name="userId")@RequestParam(value="userId")Integer userId) {  
        return userService.getUserById(userId);  
    }
      
}
