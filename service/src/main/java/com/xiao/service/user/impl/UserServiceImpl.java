package com.xiao.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiao.dao.UserMapper;
import com.xiao.model.User;
import com.xiao.model.user.UserVO;
import com.xiao.service.user.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public void addUser(UserVO user) throws Exception {
	}

	public User doUserLogin(User userLogin) {
		// TODO Auto-generated method stub
		return null;
	}
}