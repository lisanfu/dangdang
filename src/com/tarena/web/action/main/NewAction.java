package com.tarena.web.action.main;

import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DAOFactory;
import com.tarena.entity.Book;
import com.tarena.entity.Product;
import com.tarena.web.action.BaseAction;



public class NewAction extends BaseAction{
	private List<Book> books = new ArrayList<Book>();
	
	public String execute() throws Exception{
		for(Product p : DAOFactory.getProductDAO().findByNew(4)){
			books.add((Book) p);
		}
		return "new";
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
