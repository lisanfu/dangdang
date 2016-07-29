package com.tarena.dao;

import java.util.List;

import com.tarena.entity.ReceiveAddress;

public interface ReceiveAddressDAO {

	/**
	 *保存用户地址
	 */
	public void save(ReceiveAddress addr) throws Exception;

	public List<ReceiveAddress> findByUserId(int userId) throws Exception;

	public ReceiveAddress findById(int id) throws Exception;
}
