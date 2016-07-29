package com.tarena.web.action.cart;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;


import com.tarena.web.action.cart.CartItem;

import com.tarena.web.action.BaseAction;

public class CartAction extends BaseAction{
	private int id;
	private int num;
	private boolean flag;//页面购买按钮采用ajax，此值用来返回
	public String execute() throws Exception{
		
		return "success";
	}
	/**
	 * 查看
	 */
	public String view() throws Exception{
		return "success";
	}
	/**
	 * 购买
	 */
	public String buy() throws Exception{
		getCart().buy(id);
		flag=true;
		return "success";
	}
	/**
	 * 删除
	 */
	public String delete() throws Exception{
		getCart().delete(id);
		return "success";
	}
	/**
	 * 恢复
	 */
	public String recovery() throws Exception{
		getCart().recovery(id);
		return "success";
	}
	/**
	 * 更新数量
	 */
	public String modify() throws Exception{
		getCart().update(id, num);
		return "success";
	}

	/**
	 * 清空购物车
	 */
	public String clear() throws Exception{
		getCart().clearCart();
		return "success";
	}
	
	//获取购买的商品列表
	@JSON(serialize=false)
	public List<CartItem> getCiBuy() throws Exception {
		return getCart().getItems(false);
	}
	//获取删除的商品列表
	@JSON(serialize=false)
	public List<CartItem> getCiDel() throws Exception {
		return getCart().getItems(true);
	}
	//获取商品总金额(按原价计算)
	@JSON(serialize=false)
	public double getTotalFixed() throws Exception{
		return getCart().total(true);
	}
	//获取商品总金额(按当当价计算)
	@JSON(serialize=false)
	public double getTotalDang() throws Exception{
		return getCart().total(false);
	}
	@JSON(serialize=false)
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	private CartService getCart(){
		return CartFactory.getCart(CartFactory.SESSION_TYPE);
	}
}
