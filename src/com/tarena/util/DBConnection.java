package com.tarena.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
	private static String user;

	private static String password;

	private static String url;
	static {
		try {
			ClassLoader classLoader = DBConnection.class.getClassLoader();
			InputStream is = classLoader.getResourceAsStream("config/props/db.properties");
			Properties props = new Properties();
			props.load(is);
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			// 注册驱动
			Class.forName(props.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到驱动");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("加载properites文件错误");
		}
	}

	// 获取连接
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, user, password);
	}

	// 关闭连接有结果集(select)
	public static void close(ResultSet rs, Statement stat, Connection conn)
			throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (stat != null) {
			stat.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	// 关闭连接无结果集(delete update insert)
	public static void close(Statement stat, Connection conn) throws Exception {
		if (stat != null) {
			stat.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(DBConnection.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
