package com.baizhi.test;

import java.sql.Connection;

import org.junit.Test;

import com.baizhi.util.JDBCUtil3;

public class TestConn {
	@Test
	public void testConn(){
		Connection conn = JDBCUtil3.getConn();
		System.out.println(conn);
	}
}
