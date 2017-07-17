package com.xiao.service;

import com.xiao.model.User;

public interface IUserService {

	public User listUsers(Long id);
	
	public User getUserBynName(String name);

	public User doUserLogin(User userLogin);
}
