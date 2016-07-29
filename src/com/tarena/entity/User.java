package com.tarena.entity;

public class User {

	private int id;
	private String email;// --邮箱
	private String nickname;// --注册名
	private String password;// --密码
	private int user_integral;// --用户等级
	private boolean email_verify;// is_email_verify --是否email验证
	private String email_verify_code;// email_verify_code -email验证码
	private long last_login_time;// --最后一次登录的时间
	private String last_login_ip;// --登录IP

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmail_verify() {
		return email_verify;
	}

	public void setEmail_verify(boolean email_verify) {
		this.email_verify = email_verify;
	}

	public String getEmail_verify_code() {
		return email_verify_code;
	}

	public void setEmail_verify_code(String email_verify_code) {
		this.email_verify_code = email_verify_code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast_login_ip() {
		return last_login_ip;
	}

	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}

	public long getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(long last_login_time) {
		this.last_login_time = last_login_time;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser_integral() {
		return user_integral;
	}

	public void setUser_integral(int user_integral) {
		this.user_integral = user_integral;
	}

}
