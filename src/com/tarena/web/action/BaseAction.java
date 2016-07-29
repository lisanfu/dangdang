package com.tarena.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware,ServletRequestAware{
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
}
