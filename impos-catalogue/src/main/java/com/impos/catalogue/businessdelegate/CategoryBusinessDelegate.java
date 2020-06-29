package com.impos.catalogue.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.catalogue.businessdelegate.context.CategoryContext;
import com.impos.catalogue.model.CategoryModel;
import com.impos.catalogue.service.ICategoryService;
import com.impos.catalogue.domain.Category;

@Service
public class CategoryBusinessDelegate implements IBusinessDelegate<CategoryModel,CategoryContext, IKeyBuilder<String>, String>{

	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public CategoryModel create(CategoryModel model) {
		Category category = new Category();
		converter(model, category);
		categoryService.create(category);
		converter(category, model);
		return model;
	}
	@Override
	public void delete(IKeyBuilder<String> keyBuilder, CategoryContext context) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public CategoryModel edit(IKeyBuilder<String> keyBuilder, CategoryModel model) {
		if(model!=null && model.getId()!=null) {
			Category category = new Category();
			converter(model,category);
			categoryService.updateCategory(category);
			converter(category,model);
		}
		return model;
	}
	@Override
	public CategoryModel edit(IKeyBuilder<String> keyBuilder, CategoryModel model, CategoryContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CategoryModel getByKey(IKeyBuilder<String> keyBuilder, CategoryContext context) {
		Category category = categoryService.getCategory(keyBuilder.build().toString());
		CategoryModel model = new CategoryModel();
		converter(category,model);
		return model;
	}
	@Override
	public Collection<CategoryModel> getCollection(CategoryContext context) {
		List<CategoryModel> models = new ArrayList<CategoryModel>();
		for(Category category:categoryService.getAll(context)) {
			CategoryModel model = new CategoryModel();
			converter(category,model);
			models.add(model);
		}
		return models;
	}
	
	private void converter(Category source,CategoryModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(CategoryModel source, Category target) {

		BeanUtils.copyProperties(source, target);
	}
	
}
