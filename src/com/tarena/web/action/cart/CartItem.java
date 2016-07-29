package com.tarena.web.action.cart;

import com.tarena.entity.Product;

public class CartItem {
	private Product pro;
	private int num = 1;
	private boolean delete = false;// false¹ºÂò£¬trueÉ¾³ý

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	
}
