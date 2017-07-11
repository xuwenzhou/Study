package com.xu.service;

import java.util.List;

import com.xu.model.User;

public interface UserService {

	public int insertUser(User user);
	
	public User selectUserInfoById(int id);
	
	public List<User> selectUserList();
	
	public int updateUser(User user);
	
	public int deleteUser(User user);
}
