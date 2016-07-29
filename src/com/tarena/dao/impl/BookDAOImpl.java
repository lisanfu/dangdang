package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import com.tarena.dao.ProductDAO;
import com.tarena.entity.Book;
import com.tarena.entity.Product;
import com.tarena.util.DBConnection;

public class BookDAOImpl implements ProductDAO {

	private final static String FIND_BY_CAT_ID = "select dp.*,db.* "
			+ "from d_category_product dcp "
			+ "join d_product dp on (dcp.product_id=dp.id) "
			+ "join d_book db on (dp.id=db.id) "
			+ "where dcp.cat_id=? limit ?,?";

	private final static String FIND_BY_ID = "select p.*,b.* "
			+ "from d_product p " + "join d_book b " + "on p.id=b.id "
			+ "where p.id=?";

	private final static String FIND_BY_HOT = "select sum(product_num) as num,p.*,b.* "
			+ "from d_item i "
			+ "join d_product p "
			+ "ON i.product_id=p.id "
			+ "JOIN d_book b "
			+ "ON i.product_id=b.id "
			+ "GROUP BY product_id " + "ORDER BY num desc LIMIT 0,?";

	private final static String FIND_BY_NEW = "SELECT p.*,b.* "
			+ "FROM d_product p " + "JOIN d_book b " + "ON p.id=b.id "
			+ "ORDER BY p.add_time DESC " + "LIMIT 0,?";
	private final static String FIND_BY_NEW_HOT = "select sum(product_num) as num,p.*,b.* "
			+ "from d_item i "
			+ "join d_product p "
			+ "ON i.product_id=p.id "
			+ "JOIN d_book b "
			+ "ON i.product_id=b.id "
			+ "WHERE p.add_time>? "
			+ "GROUP BY product_id "
			+ "ORDER BY num desc LIMIT 0,?";

	public List<Product> findByCatId(int cid, int begin, int size)
			throws Exception {
		List<Product> pros = new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			prep = DBConnection.getConnection()
					.prepareStatement(FIND_BY_CAT_ID);
			prep.setInt(1, cid);
			prep.setInt(2, begin);
			prep.setInt(3, size);
			rs = prep.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setProduct_name(rs.getString("product_name"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setProduct_pic(rs.getString("product_pic"));
				book.setAdd_time(rs.getLong("add_time"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublish_time(rs.getLong("publish_time"));
				book.setAuthor_summary(rs.getString("author_summary"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setDescription(rs.getString("description"));
				book.setHas_deleted(rs.getInt("has_deleted"));
				book.setIsbn(rs.getString("isbn"));
				book.setKeywords(rs.getString("keywords"));
				book.setPrint_number(rs.getString("print_number"));
				book.setPrint_time(rs.getLong("print_time"));
				book.setPublishing(rs.getString("publishing"));
				book.setTotal_page(rs.getString("total_page"));
				book.setWhich_edtion(rs.getString("which_edtion"));
				book.setWord_number(rs.getString("word_number"));

				pros.add(book);
			}

		} finally {
			DBConnection.close(rs, prep, conn);
		}
		return pros;
	}

	public List<Product> findByHot(int num) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Product> pros = new ArrayList<Product>();
		try {
			prep = DBConnection.getConnection().prepareStatement(FIND_BY_HOT);
			prep.setInt(1, num);
			rs = prep.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setProduct_name(rs.getString("product_name"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setProduct_pic(rs.getString("product_pic"));
				book.setAdd_time(rs.getLong("add_time"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublish_time(rs.getLong("publish_time"));
				book.setAuthor_summary(rs.getString("author_summary"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setDescription(rs.getString("description"));
				book.setHas_deleted(rs.getInt("has_deleted"));
				book.setIsbn(rs.getString("isbn"));
				book.setKeywords(rs.getString("keywords"));
				book.setPrint_number(rs.getString("print_number"));
				book.setPrint_time(rs.getLong("print_time"));
				book.setPublishing(rs.getString("publishing"));
				book.setTotal_page(rs.getString("total_page"));
				book.setWhich_edtion(rs.getString("which_edtion"));
				book.setWord_number(rs.getString("word_number"));

				pros.add(book);
			}
		} finally {
			DBConnection.close(rs, prep, conn);
		}
		return pros;
	}

	public Product findById(int id) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		Book book = null;
		try {
			prep = DBConnection.getConnection().prepareStatement(FIND_BY_ID);
			prep.setInt(1, id);
			rs = prep.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setProduct_name(rs.getString("product_name"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setProduct_pic(rs.getString("product_pic"));
				book.setAdd_time(rs.getLong("add_time"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublish_time(rs.getLong("publish_time"));
				book.setAuthor_summary(rs.getString("author_summary"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setDescription(rs.getString("description"));
				book.setHas_deleted(rs.getInt("has_deleted"));
				book.setIsbn(rs.getString("isbn"));
				book.setKeywords(rs.getString("keywords"));
				book.setPrint_number(rs.getString("print_number"));
				book.setPrint_time(rs.getLong("print_time"));
				book.setPublishing(rs.getString("publishing"));
				book.setTotal_page(rs.getString("total_page"));
				book.setWhich_edtion(rs.getString("which_edtion"));
				book.setWord_number(rs.getString("word_number"));
			}
		} finally {
			DBConnection.close(rs, prep, conn);
		}
		return book;
	}

	public List<Product> findByNew(int num) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Product> pros = new ArrayList<Product>();
		try {
			prep = DBConnection.getConnection().prepareStatement(FIND_BY_NEW);
			prep.setInt(1, num);
			rs = prep.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setProduct_name(rs.getString("product_name"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setProduct_pic(rs.getString("product_pic"));
				book.setAdd_time(rs.getLong("add_time"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublish_time(rs.getLong("publish_time"));
				book.setAuthor_summary(rs.getString("author_summary"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setDescription(rs.getString("description"));
				book.setHas_deleted(rs.getInt("has_deleted"));
				book.setIsbn(rs.getString("isbn"));
				book.setKeywords(rs.getString("keywords"));
				book.setPrint_number(rs.getString("print_number"));
				book.setPrint_time(rs.getLong("print_time"));
				book.setPublishing(rs.getString("publishing"));
				book.setTotal_page(rs.getString("total_page"));
				book.setWhich_edtion(rs.getString("which_edtion"));
				book.setWord_number(rs.getString("word_number"));

				pros.add(book);
			}
		} finally {
			DBConnection.close(rs, prep, conn);
		}
		return pros;
	}

	public List<Product> findByNewHot(int num, long time) throws Exception {
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		List<Product> pros = new ArrayList<Product>();
		try {
			prep = DBConnection.getConnection().prepareStatement(
					FIND_BY_NEW_HOT);
			prep.setLong(1, System.currentTimeMillis() - time);
			prep.setInt(2, num);
			rs = prep.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setProduct_name(rs.getString("product_name"));
				book.setFixed_price(rs.getDouble("fixed_price"));
				book.setDang_price(rs.getDouble("dang_price"));
				book.setProduct_pic(rs.getString("product_pic"));
				book.setAdd_time(rs.getLong("add_time"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublish_time(rs.getLong("publish_time"));
				book.setAuthor_summary(rs.getString("author_summary"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setDescription(rs.getString("description"));
				book.setHas_deleted(rs.getInt("has_deleted"));
				book.setIsbn(rs.getString("isbn"));
				book.setKeywords(rs.getString("keywords"));
				book.setPrint_number(rs.getString("print_number"));
				book.setPrint_time(rs.getLong("print_time"));
				book.setPublishing(rs.getString("publishing"));
				book.setTotal_page(rs.getString("total_page"));
				book.setWhich_edtion(rs.getString("which_edtion"));
				book.setWord_number(rs.getString("word_number"));

				pros.add(book);
			}
		} finally {
			DBConnection.close(rs, prep, conn);
		}
		return pros;
	}

}
