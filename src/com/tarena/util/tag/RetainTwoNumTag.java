package com.tarena.util.tag;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.struts2.ServletActionContext;

import com.tarena.entity.Book;
import com.tarena.entity.Product;
import com.tarena.web.action.cart.CartItem;

public class RetainTwoNumTag extends SimpleTagSupport{
	private double fixedPrice;
	private double dangPrice;

	public void doTag()throws JspException,IOException{
		PageContext ctxt= (PageContext)getJspContext();
		JspWriter out = ctxt.getOut();
		HttpServletRequest request = ServletActionContext.getRequest();
		Product p = new Product();
		if(request.getAttribute("b")!=null){
			p = (Book)request.getAttribute("b");
		}else if(request.getAttribute("ci")!=null){
			CartItem ci = (CartItem)request.getAttribute("ci");
			p = ci.getPro();
		}else if(request.getAttribute("book")!=null){
			p = (Book)request.getAttribute("book");
		}else if(request.getAttribute("i")!=null){
			CartItem ci = (CartItem)request.getAttribute("i");
			p = ci.getPro();
			dangPrice = p.getDang_price();
			double cPrice = Number2(dangPrice*ci.getNum());
			out.println(cPrice);
			return;
		}
		
		fixedPrice = p.getFixed_price();
		dangPrice = p.getDang_price();
		double savePrice = fixedPrice - dangPrice;
		savePrice = Number2(savePrice);
		out.println(savePrice);
	}
	
	/**
	 * 将double型数字保留两位小数
	 * @param pDouble
	 * @return
	 */
	private double Number2(double pDouble) {
		BigDecimal bd = new BigDecimal(pDouble);
		BigDecimal bd1 = bd.setScale(2, bd.ROUND_HALF_UP);
		pDouble = bd1.doubleValue();

		return pDouble;
	}

}
