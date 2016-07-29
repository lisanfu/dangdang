package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.ReceiveAddressDAO;
import com.tarena.entity.ReceiveAddress;
import com.tarena.util.DBConnection;

public class ReceiveAddressDAOImpl implements ReceiveAddressDAO {
	private final static String SAVE = "insert into d_receive_address(user_id,receive_name,full_address,postal_code,mobile,phone) "
			+ "values(?,?,?,?,?,?)";

	private final static String FIND_BY_USER_ID = "select * from d_receive_address where user_id=?";

	private final static String FIND_BY_ID = "select * from d_receive_address where id=?";

	public ReceiveAddress findById(int id) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		ReceiveAddress addr = null;
		try {
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(FIND_BY_ID);
			prep.setInt(1, id);
			rs = prep.executeQuery();

			while (rs.next()) {
				addr = new ReceiveAddress();
				addr.setId(rs.getInt("id"));
				addr.setFull_address(rs.getString("full_address"));
				addr.setMobile(rs.getString("mobile"));
				addr.setPhone(rs.getString("phone"));
				addr.setPostal_code(rs.getString("postal_code"));
				addr.setReceive_name(rs.getString("receive_name"));
				addr.setUser_id(rs.getInt("user_id"));

			}

		} finally {
			DBConnection.close(rs, prep, conn);
		}
		return addr;
	}

	public List<ReceiveAddress> findByUserId(int userId) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<ReceiveAddress> addrs = null;
		try {
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(FIND_BY_USER_ID);
			prep.setInt(1, userId);
			rs = prep.executeQuery();
			addrs = new ArrayList<ReceiveAddress>();

			while (rs.next()) {
				ReceiveAddress addr = new ReceiveAddress();
				addr.setId(rs.getInt("id"));
				addr.setFull_address(rs.getString("full_address"));
				addr.setMobile(rs.getString("mobile"));
				addr.setPhone(rs.getString("phone"));
				addr.setPostal_code(rs.getString("postal_code"));
				addr.setReceive_name(rs.getString("receive_name"));
				addr.setUser_id(rs.getInt("user_id"));

				addrs.add(addr);
			}

		} finally {
			DBConnection.close(rs, prep, conn);
		}
		return addrs;
	}

	public void save(ReceiveAddress addr) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			prep = conn.prepareStatement(SAVE);
			prep.setInt(1, addr.getUser_id());
			prep.setString(2, addr.getReceive_name());
			prep.setString(3, addr.getFull_address());
			prep.setString(4, addr.getPostal_code());
			prep.setString(5, addr.getMobile());
			prep.setString(6, addr.getPhone());

			prep.executeUpdate();

		} finally {
			DBConnection.close(rs, prep, conn);
		}
	}

}
