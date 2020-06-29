package com.impos.catalogue.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.catalogue.businessdelegate.context.ProductSkuContext;
import com.impos.catalogue.domain.ProductSku;
import com.impos.catalogue.repository.ProductSkuRepository;

/**
 * @author Jay
 *
 */
@Component
public class ProductSkuService implements IProductSkuService{
	
	@Autowired
	private ProductSkuRepository productSkuRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;

	@Override
	public ProductSku create(ProductSku productSku) {
	     productSkuRepository.save(productSku);
		return productSku;
	}

	@Override
	public void deleteProductSku(String productSkuId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductSku getProductSku(String productSkuId) {
		// TODO Auto-generated method stub
		return productSkuRepository.findById(productSkuId).orElse(null);
	}

	@Override
	public List<ProductSku> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSku updateProductSku(ProductSku productSku) {
		if(productSku!=null) {
			ProductSku productSkum = getProductSku(productSku.getId());
			try {
				nullAwareBeanUtils.copyProperties(productSkum, productSku);
				productSkuRepository.save(productSkum);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return productSku;
	}

	@Override
	public List<ProductSku> getAll(ProductSkuContext context) {
		Specification<ProductSku> productSkuSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return productSkuRepository.findAll(productSkuSpecification);
	}
	
	

}
