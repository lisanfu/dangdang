package com.tarena.web.action.user;

import org.apache.struts2.json.annotations.JSON;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.web.action.BaseAction;

public class RegistValiAction extends BaseAction{
	private String checkCode;
	private User user;
	private boolean flag;
	
	/**
	 * 验证码验证
	 */
	public String valiCheckCode(){
		if(checkCode != null && checkCode.equalsIgnoreCase(session.get("checkCode").toString())){
			flag = true;
		}else{
			flag = false;
		}
		
		return "success";
	}
	
	/**
	 * 邮箱验证，检查邮箱是否已被注册
	 */
	public String valiEmail() throws Exception{
		UserDAO dao = DAOFactory.getUserDAO();
		User u = dao.findByEmail(user.getEmail());
		if(u!=null){
			flag=false;
		}else{
			flag=true;
		}
		return "success";
	}

	@JSON(serialize=false)
	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	@JSON(serialize=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
