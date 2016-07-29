package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.CategoryDAO;
import com.tarena.entity.Category;
import com.tarena.util.DBConnection;

public class CategoryDAOImpl implements CategoryDAO {

	private static final String FIND_ALL = "select * from d_category";
	private static final String FIND_BY_PARENT_ID = "select dc.*,count(dcp.product_id) as pnum "
			+ "from d_category dc left outer join d_category_product dcp "
			+ "on dc.id=dcp.cat_id "
			+ "where dc.parent_id=? "
			+ "group by dc.id";

	public List<Category> findAll() throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Category> cats = new ArrayList<Category>();
		try {
			prep = DBConnection.getConnection().prepareStatement(FIND_ALL);
			rs = prep.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setDescription(rs.getString("description"));
				c.setEn_name(rs.getString("en_name"));
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setParent_id(rs.getInt("parent_id"));
				cats.add(c);
			}
		} finally {
			DBConnection.close(rs, prep, conn);
		}
		return cats;
	}

	public List<Category> findByParentId(int pid) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rst= null;
		List<Category> cats = new ArrayList<Category>();
		try {
			prep = DBConnection.getConnection().prepareStatement(FIND_BY_PARENT_ID);
			prep.setInt(1, pid);
			rst= prep.executeQuery();
			while(rst.next()){
				Category c = new Category();
				c.setId(rst.getInt("id"));
				c.setEn_name(rst.getString("en_name"));
				c.setName(rst.getString("name"));
				c.setTurn(rst.getInt("turn"));
				c.setParent_id(rst.getInt("parent_id"));
				c.setDescription(rst.getString("description"));
				c.setPnum(rst.getInt("pnum"));
				
				cats.add(c);
			}
		} finally {
			DBConnection.close(rst, prep, conn);
		}
		return cats;
	}

}
