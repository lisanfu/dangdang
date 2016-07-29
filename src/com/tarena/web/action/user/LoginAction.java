package com.tarena.web.action.user;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.Md5Code;
import com.tarena.web.action.BaseAction;



public class LoginAction extends BaseAction {
	private User user;
	public String execute() throws Exception{
		//TODO 验证email和密码是否正确,不正确返回login_form.jsp
		UserDAO dao = DAOFactory.getUserDAO();
		User u = dao.findByEmail(user.getEmail());
		if(u==null || !u.getPassword().equals(Md5Code.createMd5Code(user.getPassword()))){
			request.setAttribute("login_err", "用户名或密码错误");
			return "login";
		}
		
		//TODO 更新last_login_time,last_login_ip字段
		u.setLast_login_ip(request.getRemoteAddr());
		u.setLast_login_time(System.currentTimeMillis());
		dao.update(u);
		
		//TODO 将user信息写入session
		session.put("s_user", u);
		
		//TODO 检查is_email_verify是否为true,如果没有验证,返回到verify_form.jsp
		if(!u.isEmail_verify()){
			return "verify";
		}
		
		//TODO 跳转到/main/main.jsp产品浏览界面
		return "success";
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
