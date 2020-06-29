package com.impos.catalogue.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.catalogue.businessdelegate.context.ProductContext;
import com.impos.catalogue.domain.Product;
import com.impos.catalogue.repository.ProductRepository;

/**
 * @author Jay
 *
 */
@Component
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;

	@Override
	public Product create(Product product) {
		productRepository.save(product);
		return product;
	}

	@Override
	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getProduct(String productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public List<Product> getAll() {
		return null;
	}

	@Override
	public Product updateProduct(Product product) {
		if(product!=null) {
		Product productm = getProduct(product.getId());
		try {
			nullAwareBeanUtils.copyProperties(productm, product);
			productRepository.save(productm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
   return product;
	}

	@Override
	public List<Product> getAll(ProductContext context) {
		Specification<Product> productSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return productRepository.findAll(productSpecification);
	}

	

}
