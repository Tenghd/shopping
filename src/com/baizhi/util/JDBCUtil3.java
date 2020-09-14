package com.baizhi.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil3 {
	private static Properties prop = new Properties();
	// 静态初始代码块: 这里面的代码只在类加载的时候执行一次
	static {
		// 1.加载驱动 : 将指定类的字节码文件加载到虚拟机中，只需要执行一次就可以
		InputStream in = null;
		try {
			// 读取配置文件
			in = JDBCUtil3.class.getResourceAsStream("/com/baizhi/conf/jdbc.properties");
			// 解析保存到Properties中
			prop.load(in);
			Class.forName(prop.getProperty("jdbc.driverClassName")); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	// 创建一个ThreadLocal对象： 将connection绑定到当前线程
	private static ThreadLocal<Connection> tol = new ThreadLocal<Connection>();
	
	// 创建连接，并返回给调用者
	public static Connection getConn() { 
		
		try {
			Connection conn = tol.get();
			if(conn==null){// 说明是当前线程是第一次调用，还没有绑定连接到当前线程
				// 2.创建连接
				conn = DriverManager.getConnection(
						prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username")
							, prop.getProperty("jdbc.password")); 
				// 将创建好的连接绑定到当前线程
				tol.set(conn); 
			}
			
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	// 释放资源
	public static void close(ResultSet rs, Statement stm, Connection conn) {
		try {
			// 手动避免空指针异常
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (conn != null) {
				conn.close();
				// 从当前线程移除
				tol.remove(); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Statement stm, Connection conn) {
		try {
			// 手动避免空指针异常
			if (stm != null) {
				stm.close();
			}
			if (conn != null) {
				conn.close();
				// 从当前线程移除
				tol.remove(); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
