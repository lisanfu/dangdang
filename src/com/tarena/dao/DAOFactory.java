package com.tarena.dao;

import com.tarena.dao.impl.BookDAOImpl;
import com.tarena.dao.impl.CategoryDAOImpl;
import com.tarena.dao.impl.OrderDAOImpl;
import com.tarena.dao.impl.ReceiveAddressDAOImpl;
import com.tarena.dao.impl.UserDAOImpl;

public class DAOFactory {
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}

	public static CategoryDAO getCategoryDAO() {
		return new CategoryDAOImpl();
	}

	public static ProductDAO getProductDAO() {
		return new BookDAOImpl();
	}

	public static OrderDAO getOrderDAO() {
		return new OrderDAOImpl();
	}

	public static ReceiveAddressDAO getReceiveAddressDAO() {
		return new ReceiveAddressDAOImpl();
	}
}
