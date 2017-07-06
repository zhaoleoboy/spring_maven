package com.xiao.service;

import com.xiao.entity.User;

public interface IUserService {

	public User listUsers(String id);

	public User doUserLogin(User userLogin);
}
