package com.xiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiao.dao.UserMapper;
import com.xiao.model.User;
import com.xiao.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User doUserLogin(User userLogin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User listUsers(Long id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	/**
	 * 通过username查找user
	 */
	@Override
	public User getUserBynName(String name) {
		User user = userMapper.getUserByName(name);
		return user;
	}

}