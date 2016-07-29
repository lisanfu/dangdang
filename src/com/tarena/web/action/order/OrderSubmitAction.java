package com.tarena.web.action.order;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.ReceiveAddressDAO;
import com.tarena.entity.Order;
import com.tarena.entity.ReceiveAddress;
import com.tarena.entity.User;
import com.tarena.web.action.CartRefAction;
import com.tarena.web.action.cart.CartFactory;
import com.tarena.web.action.cart.CartService;



public class OrderSubmitAction extends CartRefAction{
	private ReceiveAddress addr;
	private Order order;
	
	public String execute() throws Exception{
		//获取购物车
		CartService cart = getCart();
		//如果购物车中无商品，返回/main/main.jsp
		if(cart.getItems(false).size()==0){
			return "empty";
		}
		//获取用户id
		int userId = ((User)session.get("s_user")).getId();
		//将用户id赋给addr实例
		addr.setUser_id(userId);
		
		//创建order实例并对其赋值
		order = new Order();
		order.setFull_address(addr.getFull_address());
		order.setUser_id(userId);
		order.setMobile(addr.getMobile());
		order.setOrder_desc("desc demo");
		order.setOrder_time(System.currentTimeMillis());
		order.setPhone(addr.getPhone());
		order.setPostal_code(addr.getPostal_code());
		order.setReceive_name(addr.getReceive_name());
		order.setStatus(0);
		order.setTotal_price(cart.total(false));
		
		//通过dao将数据存入数据库中
		//保存地址信息到数据库
		ReceiveAddressDAO rDao = DAOFactory.getReceiveAddressDAO();
		if(rDao.findById(addr.getId()) == null){
			rDao.save(addr);
		}
		DAOFactory.getOrderDAO().save(order, cart);//保存订单信息到数据库
		
		//清空购物车信息
		CartFactory.removeCart(CartFactory.SESSION_TYPE);
		
		return "success";
	}

	public ReceiveAddress getAddr() {
		return addr;
	}

	public void setAddr(ReceiveAddress addr) {
		this.addr = addr;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
