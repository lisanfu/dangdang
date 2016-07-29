package com.tarena.web.action.main;

import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DAOFactory;
import com.tarena.entity.Category;
import com.tarena.web.action.BaseAction;



public class CategoryAction extends BaseAction{
	private List<Category> cats;
	
	public String execute() throws Exception{
		List<Category> list = DAOFactory.getCategoryDAO().findAll();
		cats = findByParentId(list, 1);
		
		//给子目录subCats赋值
		for (Category c : cats) {
			c.setSubCats(findByParentId(list, c.getId()));
		}
		return "category";
	}
	
	/**
	 * 根据父目录id获取子目录
	 */
	private List<Category> findByParentId(List<Category> list,int id){
		List<Category> subCats = new ArrayList<Category>();
		for (Category c : list) {
			if(c.getParent_id() == id){
				subCats.add(c);
			}
		}
		return subCats;
	}

	public List<Category> getCats() {
		return cats;
	}

	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	
}
