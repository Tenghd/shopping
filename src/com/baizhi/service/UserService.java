package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {
	void insertUser(User user);
	
	void updateByUser(User user);
	
	User selectUser(String username,String password); 

}
