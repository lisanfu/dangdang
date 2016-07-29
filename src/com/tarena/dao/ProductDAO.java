package com.tarena.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.entity.Product;



public interface ProductDAO {
	public List<Product> findByCatId(int cid,int begin,int size) throws Exception;
	public Product findById(int id) throws Exception;

	/**
	 * @param num 取出前num个数据（降序）
	 * @return 热卖商品
	 * @throws SQLException
	 */
	public List<Product> findByHot(int num) throws Exception;
	
	/**
	 * @param num 取出前num个数据（降序）
	 * @return 最新商品（按上架时间）
	 * @throws SQLException
	 */
	public List<Product> findByNew(int num) throws Exception;
	
	/**
	 * @param num 取出前num个数据（降序）
	 * @param time 多少时间内算新书
	 * @return 最新热卖商品
	 * @throws SQLException
	 */
	public List<Product> findByNewHot(int num,long time) throws Exception;
}
