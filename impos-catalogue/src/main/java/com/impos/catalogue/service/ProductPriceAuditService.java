package com.impos.catalogue.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.catalogue.businessdelegate.context.ProductPriceAuditContext;
import com.impos.catalogue.domain.ProductPriceAudit;
import com.impos.catalogue.repository.ProductPriceAuditRepository;

/**
 * @author Jay
 *
 */
@Component
public class ProductPriceAuditService implements IProductPriceAuditService{

	@Autowired
	private ProductPriceAuditRepository productPriceAuditRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;

	@Override
	public ProductPriceAudit create(ProductPriceAudit productPriceAudit) {
		productPriceAuditRepository.save(productPriceAudit);
		return productPriceAudit;
	}

	@Override
	public void deleteProductPriceAudit(String productPriceAuditId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductPriceAudit getProductPriceAudit(String productPriceAuditId) {
		// TODO Auto-generated method stub
		return productPriceAuditRepository.findById(productPriceAuditId).orElse(null);
	}

	@Override
	public List<ProductPriceAudit> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPriceAudit updateProductPriceAudit(ProductPriceAudit productPriceAudit) {
		if(productPriceAudit!=null) {
			ProductPriceAudit productPriceAuditm = getProductPriceAudit(productPriceAudit.getId());
			try {
				nullAwareBeanUtils.copyProperties(productPriceAuditm, productPriceAudit);
				productPriceAuditRepository.save(productPriceAuditm);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return productPriceAudit;
	}

	@Override
	public List<ProductPriceAudit> getAll(ProductPriceAuditContext context) {
		Specification<ProductPriceAudit> productPriceAuditSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return productPriceAuditRepository.findAll(productPriceAuditSpecification);
	}
	
}


