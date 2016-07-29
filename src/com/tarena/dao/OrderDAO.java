package com.tarena.dao;

import com.tarena.entity.Order;
import com.tarena.web.action.cart.CartService;



public interface OrderDAO {
	public void save(Order order,CartService cart) throws Exception;
}
