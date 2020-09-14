package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
	//注册信息
	void addUser(User user);
	//修改个人信息
	void updateUser(User user);
	//登录
	User selectUserNameAndPassword(String username,String password); 
}
