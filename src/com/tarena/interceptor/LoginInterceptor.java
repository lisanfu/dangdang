package com.tarena.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author qianjm
 * 检查用户是否登录的拦截器
 */
public class LoginInterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		if(session.get("s_user") == null){
			return "login";
		}
		return invocation.invoke();
	}

}
