package com.tarena.web.action.cart;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.opensymphony.xwork2.ActionContext;
import com.tarena.dao.DAOFactory;
import com.tarena.dao.ProductDAO;

public class SessionCartServiceImpl implements CartService{
	private Map<Integer, CartItem> store = new HashMap<Integer, CartItem>();
	
	public SessionCartServiceImpl(){
		//如果session中已存在购物车，则恢复store
		Map<String,Object> session = ActionContext.getContext().getSession();
		SessionCartServiceImpl cart = (SessionCartServiceImpl) session.get("s_cart");
		if(cart != null){
			this.store = cart.store;
		}
	}
	
	public void buy(int id) throws Exception {
		if(store.containsKey(id)){
			//如果购物车中已存在，产品数量+1
			CartItem ci = store.get(id);
			ci.setNum(ci.getNum()+1);
		}else{
			//如果不存在，则从数据库中找出相应商品，添加进购物车
			CartItem ci = new CartItem();
			ProductDAO pDao = DAOFactory.getProductDAO();
			ci.setPro(pDao.findById(id));
			store.put(id, ci);
		}
		
	}

	public void delete(int id) {
		if(store.containsKey(id)){
			store.get(id).setDelete(true);
		}
	}

	/**
	 * delete=true返回已删除产品列表
	 * delete=false返回确认购买列表
	 * @param delete
	 * @return
	 */
	public List<CartItem> getItems(boolean delete) {
		List<CartItem> cis = new ArrayList<CartItem>();
		for(CartItem ci : store.values()){
			if(ci.isDelete()==delete){
				cis.add(ci);
			}
		}
		return cis;
	}

	/**
	 * 恢复
	 */
	public void recovery(int id) {
		if(store.containsKey(id)){
			store.get(id).setDelete(false);
		}
	}
	
	/**
	 * 清空购物车
	 */
	public void clearCart(){
		CartFactory.removeCart(CartFactory.SESSION_TYPE);
	}

	/**
	 * 统计确认购买商品总金额
	 * flag true:统计fixed_price,false:统计dang_price
	 */
	public double total(boolean flag) {
		double totalPrice = 0.0;
			if(flag){
				for(CartItem ci : getItems(false)){
					totalPrice += ci.getNum()*ci.getPro().getFixed_price();
				}
			}else{
				for(CartItem ci : getItems(false)){
					totalPrice += ci.getNum()*ci.getPro().getDang_price();
				}
			}
			totalPrice = Number2(totalPrice);
		return totalPrice;
	}

	/**
	 * 根据id更新产品数量
	 */
	public void update(int id, int num) {
		if(store.containsKey(id)){
			store.get(id).setNum(num);
		}
	}

	public Map<Integer, CartItem> getStore() {
		return store;
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
