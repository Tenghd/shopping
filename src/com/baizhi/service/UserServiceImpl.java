package com.baizhi.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.baizhi.dao.UserDao;
import com.baizhi.dao.UserDaoImpl;
import com.baizhi.entity.User;
import com.baizhi.util.JDBCUtil3;

public class UserServiceImpl implements UserService {

	@Override
	public void insertUser(User user) {
		Connection conn=null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			UserDao dao=new UserDaoImpl();
			dao.addUser(user);
			conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("ÃÌº” ß∞‹");
		}finally{
			JDBCUtil3.close(null, conn);
		}
		
	}

	@Override
	public void updateByUser(User user) {
		Connection conn=null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			UserDao dao=new UserDaoImpl();
			dao.updateUser(user);
			conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("–ﬁ∏ƒ ß∞‹");
		}finally{
			JDBCUtil3.close(null, conn);
		}
		
	}

	@Override
	public User selectUser(String username, String password) {
		Connection conn=null;
		User user=null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			UserDao dao=new UserDaoImpl();
			user = dao.selectUserNameAndPassword(username, password);
			conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹");
		}finally{
			JDBCUtil3.close(null, conn);
		}
		return user;
	}

}
