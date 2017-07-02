package com.xiao.service.user;

import com.xiao.model.User;
import com.xiao.model.user.UserVO;

public interface IUserService {
	void addUser(UserVO user) throws Exception;

	public User doUserLogin(User userLogin);
}
