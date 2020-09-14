package com.baizhi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.baizhi.entity.Product;
import com.baizhi.util.JDBCUtil3;

public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> selectByPage(Integer begin, Integer end) {
		Connection conn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		try{
			conn=JDBCUtil3.getConn();
			String sql="select id,productName,price,picpath,discription from (select id,productName,price,picpath,discription,rownum rn from shop_product) where rn>=? and rn<=? ";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, begin);
			pstm.setInt(2, end);
			rs = pstm.executeQuery();
			while(rs.next()){
				Product p=new Product(
							rs.getInt(1),
							rs.getString(2),
							rs.getDouble(3),
							rs.getString(4),
							rs.getString(5)
						);
				list.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹");
		}finally{
			JDBCUtil3.close(rs, pstm, null);
		}
		return list;
	}

	@Override
	public Integer totalPage() {
		Connection conn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Integer count=null;
		try{
			conn=JDBCUtil3.getConn();
			String sql="select count(*) from shop_product ";
			pstm=conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹");
		}finally{
			JDBCUtil3.close(rs, pstm, null);
		}
		return count;
	}

	@Override
	public List<Product> selectByName(String productName) {
		Connection conn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		try{
			conn=JDBCUtil3.getConn();
			String sql="select id,productName,price,picpath,discription from shop_product where productName like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, "%"+productName+"%");
			rs = pstm.executeQuery();
			while(rs.next()){
				Product p=new Product(
							rs.getInt(1),
							rs.getString(2),
							rs.getDouble(3),
							rs.getString(4),
							rs.getString(5)
						);
				list.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹");
		}finally{
			JDBCUtil3.close(rs, pstm, null);
		}
		return list;
	}

	

	@Override
	public Product selectById(Integer id) {
		Connection conn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Product p=null;
		try{
			conn=JDBCUtil3.getConn();
			String sql="select id,productName,price,picpath,discription from shop_product where id=?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while(rs.next()){
				p=new Product(
					rs.getInt(1),
					rs.getString(2),
					rs.getDouble(3),
					rs.getString(4),
					rs.getString(5)
				);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹");
		}finally{
			JDBCUtil3.close(rs, pstm, null);
		}
		return p;
	}

	@Override
	public List<Product> selectByPriceD(Double priceD) {
		Connection conn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		try{
			conn=JDBCUtil3.getConn();
			String sql="select id,productName,price,picpath,discription from shop_product where price>?";
			pstm=conn.prepareStatement(sql);
			pstm.setDouble(1,priceD);
			rs = pstm.executeQuery();
			while(rs.next()){
				Product p=new Product(
							rs.getInt(1),
							rs.getString(2),
							rs.getDouble(3),
							rs.getString(4),
							rs.getString(5)
						);
				list.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹");
		}finally{
			JDBCUtil3.close(rs, pstm, null);
		}
		return list;
	}

	@Override
	public List<Product> selectByPriceX(Double priceX) {
		Connection conn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		try{
			conn=JDBCUtil3.getConn();
			String sql="select id,productName,price,picpath,discription from shop_product where price<?";
			pstm=conn.prepareStatement(sql);
			pstm.setDouble(1,priceX);
			rs = pstm.executeQuery();
			while(rs.next()){
				Product p=new Product(
							rs.getInt(1),
							rs.getString(2),
							rs.getDouble(3),
							rs.getString(4),
							rs.getString(5)
						);
				list.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹");
		}finally{
			JDBCUtil3.close(rs, pstm, null);
		}
		return list;
	}

	@Override
	public List<Product> selectByNameAndPriceD(String productName, Double priceD) {
		Connection conn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		try{
			conn=JDBCUtil3.getConn();
			String sql="select id,productName,price,picpath,discription from shop_product where productName like ? and price>?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, "%"+productName+"%");
			pstm.setDouble(2,priceD);
			rs = pstm.executeQuery();
			while(rs.next()){
				Product p=new Product(
							rs.getInt(1),
							rs.getString(2),
							rs.getDouble(3),
							rs.getString(4),
							rs.getString(5)
						);
				list.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹");
		}finally{
			JDBCUtil3.close(rs, pstm, null);
		}
		return list;
	}

	@Override
	public List<Product> selectByNameAndPriceX(String productName, Double priceX) {
		Connection conn =null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		try{
			conn=JDBCUtil3.getConn();
			String sql="select id,productName,price,picpath,discription from shop_product where productName like ? and price<?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, "%"+productName+"%");
			pstm.setDouble(2, priceX);
			rs = pstm.executeQuery();
			while(rs.next()){
				Product p=new Product(
							rs.getInt(1),
							rs.getString(2),
							rs.getDouble(3),
							rs.getString(4),
							rs.getString(5)
						);
				list.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("≤È—Ø ß∞‹");
		}finally{
			JDBCUtil3.close(rs, pstm, null);
		}
		return list;
	}

	
	

}
