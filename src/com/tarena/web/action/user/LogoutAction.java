package com.tarena.web.action.user;

import com.tarena.web.action.BaseAction;



public class LogoutAction extends BaseAction{
	public String execute(){
		session.clear();
		return "success";
	}
}
