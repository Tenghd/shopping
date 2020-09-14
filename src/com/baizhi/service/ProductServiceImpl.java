package com.baizhi.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.baizhi.dao.ProductDao;
import com.baizhi.dao.ProductDaoImpl;
import com.baizhi.entity.Product;
import com.baizhi.util.JDBCUtil3;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> queryByPage(Integer currentPage, Integer pageSize) {
		Connection conn =null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			ProductDao dao=new ProductDaoImpl();
			Integer begin=(currentPage-1)*pageSize+1;
			Integer end=currentPage*pageSize;
			List<Product> list = dao.selectByPage(begin, end);
			conn.commit();
			return list;
			
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
	}

	@Override
	public Integer totalPageService(Integer pageSize) {
		Connection conn =null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			ProductDao dao=new ProductDaoImpl();
			Integer count = dao.totalPage();
			Integer totalPage=count%pageSize==0?count/pageSize:(count/pageSize)+1;
			conn.commit();
			return totalPage;
			
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
	}

	@Override
	public List<Product> queryByName(String productName) {
		Connection conn =null;
		List<Product> list=null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			ProductDao dao=new ProductDaoImpl();
			list = dao.selectByName(productName);
			conn.commit();
			return list;
			
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
	}

	

	
	@Override
	public Product queryById(Integer id) {
		Connection conn =null;
		Product p=null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			ProductDao dao=new ProductDaoImpl();
			p = dao.selectById(id);
			conn.commit();
			return p;
			
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
	}

	@Override
	public List<Product> queryByPriceD(Double priceD) {
		Connection conn =null;
		List<Product> list=null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			ProductDao dao=new ProductDaoImpl();
			list = dao.selectByPriceD(priceD);
			conn.commit();
			return list;
			
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
	}

	@Override
	public List<Product> queryByPriceX(Double priceX) {
		Connection conn =null;
		List<Product> list=null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			ProductDao dao=new ProductDaoImpl();
			list = dao.selectByPriceX(priceX);
			conn.commit();
			return list;
			
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
	}

	@Override
	public List<Product> queryByNameAndPriceD(String productName, Double priceD) {
		Connection conn =null;
		List<Product> list=null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			ProductDao dao=new ProductDaoImpl();
			list = dao.selectByNameAndPriceD(productName, priceD);
			conn.commit();
			return list;
			
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
	}

	@Override
	public List<Product> queryByNameAndPriceX(String productName, Double priceX) {
		Connection conn =null;
		List<Product> list=null;
		try{
			conn=JDBCUtil3.getConn();
			conn.setAutoCommit(false);
			ProductDao dao=new ProductDaoImpl();
			list = dao.selectByNameAndPriceX(productName, priceX);
			conn.commit();
			return list;
			
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
	}

}
