package com.tarena.web.action.cart;

import java.util.List;



public interface CartService {
	public void buy(int id) throws Exception;
	public void update(int id,int num) throws Exception;
	public void delete(int id) throws Exception;
	public void recovery(int id) throws Exception;
	public void clearCart() throws Exception;
	/**
	 * @param flag true 统计fixed_price 
	 * flag false 统计dang_price
	 * @return
	 */
	public double total(boolean flag) throws Exception;
	public List<CartItem> getItems(boolean delete) throws Exception;//返回产品集合
}
