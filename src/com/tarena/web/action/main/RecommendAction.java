package com.tarena.web.action.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.ProductDAO;
import com.tarena.entity.Book;
import com.tarena.web.action.BaseAction;


public class RecommendAction extends BaseAction{
	private List<Book> books=new ArrayList<Book>();
	
	public String execute() throws Exception{
		ProductDAO pDao = DAOFactory.getProductDAO();
		//随机选择2本
		books.add((Book) pDao.findById(new Random().nextInt(20)));
		books.add((Book) pDao.findById(new Random().nextInt(20)));
		
		return "recommend";
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
