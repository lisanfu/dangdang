package com.tarena.Test;

import java.util.List;

import com.tarena.dao.impl.ReceiveAddressDAOImpl;
import com.tarena.entity.ReceiveAddress;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		List<ReceiveAddress> list = new ReceiveAddressDAOImpl().findByUserId(1);
      for (ReceiveAddress receiveAddress : list) {
		System.out.println(receiveAddress.getFull_address());
	}
	}

}
