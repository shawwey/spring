package com.shaw.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaw.cn.dao.UserDao;
import com.shaw.cn.entity.User;
import com.shaw.cn.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserDao userDao;
	
    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }    

}
