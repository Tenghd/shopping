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
	// ��̬��ʼ�����: ������Ĵ���ֻ������ص�ʱ��ִ��һ��
	static {
		// 1.�������� : ��ָ������ֽ����ļ����ص�������У�ֻ��Ҫִ��һ�ξͿ���
		InputStream in = null;
		try {
			// ��ȡ�����ļ�
			in = JDBCUtil3.class.getResourceAsStream("/com/baizhi/conf/jdbc.properties");
			// �������浽Properties��
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
	// ����һ��ThreadLocal���� ��connection�󶨵���ǰ�߳�
	private static ThreadLocal<Connection> tol = new ThreadLocal<Connection>();
	
	// �������ӣ������ظ�������
	public static Connection getConn() { 
		
		try {
			Connection conn = tol.get();
			if(conn==null){// ˵���ǵ�ǰ�߳��ǵ�һ�ε��ã���û�а����ӵ���ǰ�߳�
				// 2.��������
				conn = DriverManager.getConnection(
						prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username")
							, prop.getProperty("jdbc.password")); 
				// �������õ����Ӱ󶨵���ǰ�߳�
				tol.set(conn); 
			}
			
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	// �ͷ���Դ
	public static void close(ResultSet rs, Statement stm, Connection conn) {
		try {
			// �ֶ������ָ���쳣
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (conn != null) {
				conn.close();
				// �ӵ�ǰ�߳��Ƴ�
				tol.remove(); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Statement stm, Connection conn) {
		try {
			// �ֶ������ָ���쳣
			if (stm != null) {
				stm.close();
			}
			if (conn != null) {
				conn.close();
				// �ӵ�ǰ�߳��Ƴ�
				tol.remove(); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
