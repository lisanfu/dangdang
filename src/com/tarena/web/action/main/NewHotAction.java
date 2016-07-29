package com.tarena.web.action.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DAOFactory;
import com.tarena.entity.Book;
import com.tarena.entity.Product;
import com.tarena.web.action.BaseAction;



public class NewHotAction extends BaseAction{
	private List<Book> books = new ArrayList<Book>();

	public String execute() throws Exception{
		long time = 1000L*60*60*24*30*100;//由于数据库测试数据偏旧，所以给的值略大
		for(Product p : DAOFactory.getProductDAO().findByNewHot(4, time)){
			books.add((Book) p);
		}
		return "newhot";
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
