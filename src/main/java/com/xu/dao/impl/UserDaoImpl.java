package com.xu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.xu.dao.UserDao;
import com.xu.model.User;

public class UserDaoImpl implements UserDao{
	
	@Resource
	public SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insertUser(User user) {
		// TODO 添加新用户
		return 0;
	}

	@Override
	public User selectUserInfoById(int id) {
		// TODO 通过ID查询用户信息
		return sqlSessionTemplate.selectOne("selectUserInfoById", id);
	}

	@Override
	public List<User> selectUserList() {
		// TODO 查询所有用户列表
		return null;
	}

	@Override
	public int updateUser(User user) {
		// TODO 更新用户信息
		return 0;
	}

	@Override
	public int deleteUser(User user) {
		// TODO 删除用户信息
		return 0;
	}

	
}
