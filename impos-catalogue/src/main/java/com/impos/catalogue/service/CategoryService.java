package com.impos.catalogue.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.catalogue.businessdelegate.context.CategoryContext;
import com.impos.catalogue.domain.Category;
import com.impos.catalogue.repository.CategoryRepository;

/**
 * @author Jay
 *
 */
@Component
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;
	
	@Override
	public Category create(Category category) {
	    categoryRepository.save(category);
		return category;
	}
	@Override
	public void deleteCategory(String categoryId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(categoryId).orElse(null);
	}
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Category updateCategory(Category category) {
		if(category!=null) {
			Category categorym = getCategory(category.getId());
			try {
				nullAwareBeanUtils.copyProperties(categorym, category);
				categoryRepository.save(categorym);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 return category;
	
	}
	@Override
	public List<Category> getAll(CategoryContext context) {
		Specification<Category> categorySpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};	
		return categoryRepository.findAll(categorySpecification);
	}

}
