package com.schoolapp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapp.dao.UserDao;
import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.Category;
import com.schoolapp.entity.User;

@Service
public class CategoryService {
	@Autowired

	com.schoolapp.dao.CategoryDao CategoryDao;

	public Category saveCategory(Category Category) {
		return CategoryDao.saveCategory(Category);
	}

	public List<Category> getAllCategory() {
		return CategoryDao.getAllCategory();
	}

	public Category findCategoryById(int CategoryId) {
		return CategoryDao.findCategoryById(CategoryId);
	}  
   
	public Category updateCategory(Category CategoryId) {
		Integer cId = CategoryId.getCategoryId();
		Category Category = CategoryDao.findCategoryById(CategoryId.getCategoryId());
		Category.setCategoryId(CategoryId.getCategoryId());
		Category.setCategoryName(CategoryId.getCategoryName());
		return CategoryDao.saveCategory(Category);
	}
	
	

	public String deleteCategoryById(int CategoryId) {
		CategoryDao.deleteCategoryById(CategoryId);
		return "deleted";
	}
}
