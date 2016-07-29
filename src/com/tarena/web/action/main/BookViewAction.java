package com.tarena.web.action.main;

import java.sql.SQLException;

import com.tarena.dao.DAOFactory;
import com.tarena.dao.ProductDAO;
import com.tarena.entity.Book;
import com.tarena.web.action.BaseAction;


public class BookViewAction extends BaseAction{
	private Book book;
	private int id;
	
	public String execute() throws Exception{
		//通过dao获取书本信息
		ProductDAO pDao = DAOFactory.getProductDAO();
		book = (Book) pDao.findById(id);
		return "bookview";
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
