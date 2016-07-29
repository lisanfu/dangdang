package com.tarena.web.action;

import com.tarena.web.action.cart.CartFactory;
import com.tarena.web.action.cart.CartService;



public class CartRefAction extends BaseAction{
	protected CartService getCart(){
		return CartFactory.getCart(CartFactory.SESSION_TYPE);
	}
}
