package com.tarena.web.action.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DAOFactory;
import com.tarena.entity.Book;
import com.tarena.entity.Product;
import com.tarena.web.action.BaseAction;



public class HotAction extends BaseAction{
	private List<Book> books;
	
	public String execute() throws Exception{
		books = new ArrayList<Book>();
		List<Product> pros =  DAOFactory.getProductDAO().findByHot(4);
		for (Product p : pros) {
			books.add((Book) p);
		}
		return "hot";
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
