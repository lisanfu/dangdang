package com.tarena.entity;

public class Order {

	//	 

	private int id;// id int(10) NOT NULL auto_increment,
	private int user_id;// user_id int(10) NOT NULL, --用户
	private int status;// status int(10) NOT NULL, -- 用户状态
	private long order_time;// order_time bigint(20) NOT NULL, --订单时间
	private String order_desc;// order_desc varchar(100) default NULL, --订单描述
	private double total_price;// total_price double NOT NULL, --总价
	private String receive_name;// receive_name varchar(100) default NULL,
	// --送货名字
	private String full_address;// full_address varchar(200) default NULL,
	// --送货地址
	private String postal_code;// postal_code varchar(8) default NULL,邮编
	private String mobile;// mobile varchar(20) default NULL, 手机号
	private String phone;// phone varchar(20) default NULL,电话

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int userId) {
		user_id = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getOrder_time() {
		return order_time;
	}

	public void setOrder_time(long orderTime) {
		order_time = orderTime;
	}

	public String getOrder_desc() {
		return order_desc;
	}

	public void setOrder_desc(String orderDesc) {
		order_desc = orderDesc;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double totalPrice) {
		total_price = totalPrice;
	}

	public String getReceive_name() {
		return receive_name;
	}

	public void setReceive_name(String receiveName) {
		receive_name = receiveName;
	}

	public String getFull_address() {
		return full_address;
	}

	public void setFull_address(String fullAddress) {
		full_address = fullAddress;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postalCode) {
		postal_code = postalCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
