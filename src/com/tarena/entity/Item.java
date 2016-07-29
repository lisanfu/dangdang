package com.tarena.entity;

public class Item {

	private int id;// id int(12) NOT NULL auto_increment,
	private int order_id;// order_id int(10) NOT NULL, --订单
	private int product_id;// product_id int(10) NOT NULL, --产品
	private String product_name;// product_name varchar(100) NOT NULL, --产品名字
	private double dang_price;// dang_price double NOT NULL, --当当价格
	private int product_num;// product_num int(10) NOT NULL, --购买产品数量
	private double amount;// amount double NOT NULL, --小计

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int orderId) {
		order_id = orderId;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int productId) {
		product_id = productId;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String productName) {
		product_name = productName;
	}

	public double getDang_price() {
		return dang_price;
	}

	public void setDang_price(double dangPrice) {
		dang_price = dangPrice;
	}

	public int getProduct_num() {
		return product_num;
	}

	public void setProduct_num(int productNum) {
		product_num = productNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
