package com.tarena.entity;

public class Product {
/**
 * 产品属性
 */
	private int id;
	private String product_name;		// product_name --产品名字
	private String description;				// description --产品描述
	private long add_time;					// add_time --添加产品的时间
	private double fixed_price;			// fixed_price --固定价格
	private double dang_price;			// dang_price , --当当价格
	private String keywords;				// keywords --关键搜索
	private int has_deleted;					// has_deleted int(1) NOT NULL default '0', --是否删除
	private String product_pic;				// product_pic --产品图片

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String productName) {
		product_name = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getAdd_time() {
		return add_time;
	}

	public void setAdd_time(long addTime) {
		add_time = addTime;
	}

	public double getFixed_price() {
		return fixed_price;
	}

	public void setFixed_price(double fixedPrice) {
		fixed_price = fixedPrice;
	}

	public double getDang_price() {
		return dang_price;
	}

	public void setDang_price(double dangPrice) {
		dang_price = dangPrice;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getHas_deleted() {
		return has_deleted;
	}

	public void setHas_deleted(int hasDeleted) {
		has_deleted = hasDeleted;
	}

	public String getProduct_pic() {
		return product_pic;
	}

	public void setProduct_pic(String productPic) {
		product_pic = productPic;
	}

}
