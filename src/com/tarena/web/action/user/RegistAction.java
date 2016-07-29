package com.tarena.web.action.user;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.EmailCode;
import com.tarena.util.Md5Code;
import com.tarena.web.action.BaseAction;


public class RegistAction extends BaseAction{
	private User user;
	private String checkCode;
	
	public String execute() throws Exception{
		//将密码加密
		String pwd = Md5Code.createMd5Code(user.getPassword());
		user.setPassword(pwd);
		
		user.setUser_integral(10);
		user.setEmail_verify(false);
		
		String emailCode = EmailCode.createEmailCode();
		user.setEmail_verify_code(emailCode);
		user.setLast_login_time(System.currentTimeMillis());
		user.setLast_login_ip(request.getRemoteAddr());
		UserDAO userDao = DAOFactory.getUserDAO();
		userDao.save(user);
		session.put("s_user", user);
		
		//发送邮箱验证码,测试时直接显示在页面上方便调试
		
		//String emailCode = verifyCode+"-"+user.getId();
		//EmailUtil.sendEmail(emailCode, user.getEmail());
		
		return "verify";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	
}
