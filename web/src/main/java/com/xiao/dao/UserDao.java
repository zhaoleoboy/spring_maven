package com.xiao.dao;

import com.xiao.model.User;

public interface UserDao {
	public void saveUser(final User user);

	public User getUser(final long id);
}
