package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDao {
	//ע����Ϣ
	void addUser(User user);
	//�޸ĸ�����Ϣ
	void updateUser(User user);
	//��¼
	User selectUserNameAndPassword(String username,String password); 
}
