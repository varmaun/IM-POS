package com.impos.catalogue.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.businessdelegate.model.SimpleIdKeyBuilder;
import com.impos.catalogue.businessdelegate.context.CategoryContext;
import com.impos.catalogue.model.CategoryModel;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/category", produces = "application/json", consumes = "application/json")

public class CategoryController {

	private IBusinessDelegate<CategoryModel, CategoryContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<CategoryContext> categoryContextFactory;
	
	@PostMapping(value = "/create")
	public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel category) {

		businessDelegate.create(category);
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryModel> getCategory(@PathVariable(value = "id") final String categoryId) {
		CategoryContext categoryContext = categoryContextFactory.getObject();
		CategoryModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(categoryId), categoryContext);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<CategoryModel>> getCategory(
			@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "cid", required = false) final String companyId) {
		CategoryContext categoryContext = categoryContextFactory.getObject();
		categoryContext.getContextParams().put("status", status);
		categoryContext.getContextParams().put("companyId", companyId);
		List<CategoryModel> models = (List<CategoryModel>) businessDelegate.getCollection(categoryContext);
		return new ResponseEntity<>(models, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<CategoryModel> editCategory(@PathVariable(value = "id") final String categoryId,
			@RequestBody CategoryModel categoryModel) {
		categoryModel = businessDelegate.edit(null, categoryModel);
		return new ResponseEntity<>(categoryModel, HttpStatus.CREATED);
	}
	
	/**
	 * @param businessDelegate
	 */
	@Resource(name = "categoryBusinessDelegate")

	public void setBusinessDelegate(
			final IBusinessDelegate<CategoryModel, CategoryContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setCategoryObjectFactory(final ObjectFactory<CategoryContext> categoryContextFactory) {
		this.categoryContextFactory = categoryContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}
	
}
