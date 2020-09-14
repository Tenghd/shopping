package com.baizhi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.baizhi.entity.User;
import com.baizhi.util.JDBCUtil3;

public class UserDaoImpl implements UserDao{

	@Override
	public void addUser(User user) {
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=JDBCUtil3.getConn();
			String sql="insert into shop_user values(?,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getName());
			pstm.setInt(4, user.getZip());
			pstm.setString(5, user.getAddress());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw  new RuntimeException("ÃÌº” ß∞‹");
		}finally{
			JDBCUtil3.close(pstm, null);
		}	
	}

	@Override
	public void updateUser(User user) {
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=JDBCUtil3.getConn();
			String sql="update shop_user set password=?,name=?,zip=?,address=? where username=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getPassword());
			pstm.setString(2, user.getName());
			pstm.setInt(3, user.getZip());
			pstm.setString(4, user.getAddress());
			pstm.setString(5, user.getUsername());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw  new RuntimeException("–ﬁ∏ƒ ß∞‹");
		}finally{
			JDBCUtil3.close(pstm, null);
		}	
		
	}

	@Override
	public User selectUserNameAndPassword(String username, String password) {
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		User user=null;
		try{
			conn=JDBCUtil3.getConn();
			String sql="select username,password,name,zip,address from shop_user where username=? and password=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs=pstm.executeQuery();
			while(rs.next()){
				user=new User(
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getInt(4),
							rs.getString(5)
						);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw  new RuntimeException("≤È—Ø ß∞‹");
		}finally{
			JDBCUtil3.close(rs,pstm, null);
		}
		return user;	
	}

}
