package com.impos.catalogue.service;

import java.util.List;

import com.impos.catalogue.domain.Category;
import com.impos.catalogue.businessdelegate.context.CategoryContext;

public interface ICategoryService {
	
	Category create(Category category);

	void deleteCategory(String categoryId);

	Category getCategory(String category);

	List<Category> getAll();

	Category updateCategory(Category category);

	List<Category> getAll(CategoryContext context);


}
