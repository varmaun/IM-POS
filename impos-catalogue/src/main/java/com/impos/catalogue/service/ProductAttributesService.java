package com.impos.catalogue.service;
/**
 * @author Jay
 *
 */

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.catalogue.businessdelegate.context.ProductAttributesContext;
import com.impos.catalogue.domain.ProductAttributes;
import com.impos.catalogue.repository.ProductAttributesRepository;

@Component
public class ProductAttributesService implements IProductAttributesService{
	
	@Autowired
	private ProductAttributesRepository productAttributesRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;
	@Override
	
	public ProductAttributes create(ProductAttributes productAttributes) {
		productAttributesRepository.save(productAttributes);
		return productAttributes;
	}

	@Override
	public void deleteProductAttributes(String productAttributesId) {
		
	}

	@Override
	public ProductAttributes getProductAttributes(String productAttributesId) {
		return productAttributesRepository.findById(productAttributesId).orElse(null);
	}

	@Override
	public List<ProductAttributes> getAll() {
		return null;
	}

	@Override
	public ProductAttributes updateProductAttributes(ProductAttributes productAttributes) {
		if(productAttributes!=null) {
			ProductAttributes productAttributesm = getProductAttributes(productAttributes.getId());
			try {
				nullAwareBeanUtils.copyProperties(productAttributesm, productAttributes );
				productAttributesRepository.save(productAttributesm);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	return productAttributes;
	}

	@Override
	public List<ProductAttributes> getAll(ProductAttributesContext context) {
		Specification<ProductAttributes> productAttributesSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return productAttributesRepository.findAll(productAttributesSpecification);
	}
	

}
