package com.tarena.web.action.order;

import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DAOFactory;
import com.tarena.entity.ReceiveAddress;
import com.tarena.entity.User;
import com.tarena.web.action.BaseAction;



public class AddressAction extends BaseAction{
	private List<ReceiveAddress> addrs = new ArrayList<ReceiveAddress>();
	
	public String execute() throws Exception{
		//从session中获取userId
		int userId = ((User)session.get("s_user")).getId();
		System.out.println(userId);
		//从数据库中获取与userId对应的地址
		addrs = DAOFactory.getReceiveAddressDAO().findByUserId(userId);
		System.out.println(addrs);
		return "success";
	}
	
	public List<ReceiveAddress> getAddrs() {
		return addrs;
	}

	public void setAddrs(List<ReceiveAddress> addrs) {
		this.addrs = addrs;
	}

}
