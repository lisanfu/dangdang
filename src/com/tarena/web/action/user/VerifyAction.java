package com.tarena.web.action.user;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.EmailCode;

import com.tarena.web.action.BaseAction;



public class VerifyAction extends BaseAction {
	private String code;
	
	public String execute() {
		//TODO 将用户输入的验证码解析,解析出用户ID和verifyCode
		String uid=EmailCode.getUid(code);
		if(uid==null){
			request.setAttribute("verify_err", "邮箱验证码错误，请检查后重输");
			return "verify";
		}	
		int id = Integer.parseInt(uid);
		String vCode = EmailCode.getUUID(code);
		
		//TODO 去数据库比较是否正确
		UserDAO dao = DAOFactory.getUserDAO();
		try {User u = dao.findById(id);
		//TODO 如果正确,将is_email_verify字段更新,跳转到register_ok.jsp
		if(u != null &&vCode.trim().equals(u.getEmail_verify_code())){
			u.setEmail_verify(true);
			dao.update(u);
			return "success";
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		//TODO 如果不正确,返回到verify_form.jsp,显示提示信息
		request.setAttribute("verify_err", "邮箱验证码错误，请检查后重输");
		return "verify";
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
