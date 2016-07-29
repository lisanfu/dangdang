package com.tarena.Test;

import java.sql.SQLException;
import java.util.List;

import com.tarena.dao.CategoryDAO;
import com.tarena.dao.DAOFactory;
import com.tarena.entity.Category;


public class CategoryDAOTest {
	public static void main(String[] args) throws Exception {
		CategoryDAO dao = DAOFactory.getCategoryDAO();
		List<Category> list = dao.findByParentId(0);
		for (Category c : list) {
			System.out.println(c.getId()+"-"+(c.getDescription()==null));
		}
	}
}
