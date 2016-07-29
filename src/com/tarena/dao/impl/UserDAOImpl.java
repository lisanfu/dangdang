package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
import com.tarena.util.DBConnection;

public class UserDAOImpl implements UserDAO {

	private static final String INSERT = "insert into d_user(email,nickname,password,user_integral,is_email_verify,email_verify_code,last_login_time,last_login_ip) values(?,?,?,?,?,?,?,?)";
	private static final String FINDBYEMAIL = "select * from d_user where email=?";
	private static final String FINDBYID = "select * from d_user where id=?";
	private static final String UPDATE = "update d_user set email=?,nickname=?,password=?,user_integral=?,is_email_verify=?,email_verify_code=?,last_login_time=?,last_login_ip=? where id=?";

	public User findByEmail(String email) throws Exception {
		PreparedStatement prep = null;
		Connection conn = null;
		User u = null;
		ResultSet rst = null;
		try {
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(FINDBYEMAIL);
			prep.setString(1, email);
			rst = prep.executeQuery();
			if (rst.next()) {
				u = new User();
				u.setEmail(rst.getString("email"));
				u.setEmail_verify_code(rst.getString("email_verify_code"));
				u.setId(rst.getInt("id"));
				u.setLast_login_ip(rst.getString("last_login_ip"));
				u.setLast_login_time(rst.getLong("last_login_time"));
				u.setNickname(rst.getString("nickname"));
				u.setPassword(rst.getString("password"));
				u.setUser_integral(rst.getInt("user_integral"));

				String is_email_verify = rst.getString("is_email_verify");
				if (is_email_verify.equals("T")) {
					u.setEmail_verify(true);
				} else {
					u.setEmail_verify(false);
				}

			}

		} finally {
			DBConnection.close(prep, conn);
		}
		return u;
	}

	public User findById(int id) throws Exception {
		PreparedStatement prep = null;
		Connection conn = null;
		User u = null;
		try {
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(FINDBYID);
			prep.setInt(1, id);
			ResultSet rst = prep.executeQuery();
			if (rst.next()) {
				u = new User();
				u.setEmail(rst.getString("email"));
				u.setEmail_verify_code(rst.getString("email_verify_code"));
				u.setId(rst.getInt("id"));
				u.setLast_login_ip(rst.getString("last_login_ip"));
				u.setLast_login_time(rst.getLong("last_login_time"));
				u.setNickname(rst.getString("nickname"));
				u.setPassword(rst.getString("password"));
				u.setUser_integral(rst.getInt("user_integral"));

				String is_email_verify = rst.getString("is_email_verify");
				if (is_email_verify.equals("T")) {
					u.setEmail_verify(true);
				} else {
					u.setEmail_verify(false);
				}

			}

		} finally {
			DBConnection.close(prep, conn);
		}
		return u;
	}

	public void save(User user) throws Exception {
		PreparedStatement prep = null;
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(INSERT,
					Statement.RETURN_GENERATED_KEYS);
			prep.setString(1, user.getEmail());
			prep.setString(2, user.getNickname());
			prep.setString(3, user.getPassword());
			prep.setInt(4, user.getUser_integral());
			if (user.isEmail_verify()) {
				prep.setString(5, "T");
			} else {
				prep.setString(5, "F");
			}
			prep.setString(6, user.getEmail_verify_code());
			prep.setLong(7, user.getLast_login_time());
			prep.setString(8, user.getLast_login_ip());

			prep.executeUpdate();
			ResultSet rst = prep.getGeneratedKeys();
			rst.next();
			int id = rst.getInt(1);
			user.setId(id);
		} finally {
			DBConnection.close(prep, conn);
		}
	}

	public void update(User u) throws Exception {
		PreparedStatement prep = null;
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(UPDATE);
			prep.setString(1, u.getEmail());
			prep.setString(2, u.getNickname());
			prep.setString(3, u.getPassword());
			prep.setInt(4, u.getUser_integral());
			if (u.isEmail_verify()) {
				prep.setString(5, "T");
			} else {
				prep.setString(5, "F");
			}
			prep.setString(6, u.getEmail_verify_code());
			prep.setLong(7, u.getLast_login_time());
			prep.setString(8, u.getLast_login_ip());
			prep.setInt(9, u.getId());

			prep.executeUpdate();
		} finally {
			DBConnection.close(prep, conn);
		}
	}

}
