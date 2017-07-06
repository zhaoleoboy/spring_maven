package com.xiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiao.entity.User;
import com.xiao.mapper.UserMapper;
import com.xiao.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User listUsers(String id) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public User doUserLogin(User userLogin) {
		// TODO Auto-generated method stub
		return null;
	}


}