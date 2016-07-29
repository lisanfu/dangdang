package com.tarena.web.action.order;

import java.util.List;

import com.tarena.web.action.CartRefAction;
import com.tarena.web.action.cart.CartItem;



public class OrderConfirmAction extends CartRefAction{
	private List<CartItem> items;//购物车中的商品信息(CartItem)表
	
	public String execute() throws Exception{
		items = getCart().getItems(false);
		//如果购物车中商品为空，提示错误
		
		if(items.size()==0){
		//	request.setAttribute("cart_empty", "未购买商品，请购买商品后再结算");
			return "empty";
		}
		
		return "success";
	}
	
	//获取商品总金额(按当当价计算)
	public double getTotalDang() throws Exception{
		return getCart().total(false);
	}
	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
}
