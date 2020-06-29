package com.impos.settings.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.settings.businessdelegate.context.TaxRateContext;
import com.impos.settings.domain.TaxRate;
import com.impos.settings.repository.TaxRateRepository;

/**
 * @author Jay
 *
 */
@Component
public class TaxRateService implements  ITaxRateService{
	
	@Autowired
	private TaxRateRepository taxRateRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;

	@Override
	public TaxRate create(TaxRate taxRate) {
		taxRateRepository.save(taxRate);
		return taxRate;
	}

	@Override
	public void deleteTaxRate(String taxRateId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaxRate getTaxRate(String taxRateId) {
		// TODO Auto-generated method stub
		return taxRateRepository.findById(taxRateId).orElse(null);
	}

	@Override
	public List<TaxRate> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxRate updateTaxRate(TaxRate taxRate) {
		if(taxRate!=null) {
			TaxRate tr = getTaxRate(taxRate.getId());
			try {
				nullAwareBeanUtils.copyProperties(tr, taxRate);
				taxRateRepository.save(tr);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return taxRate;
	}

	@Override
	public List<TaxRate> getAll(TaxRateContext context) {
		Specification<TaxRate> taxRateSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return taxRateRepository.findAll(taxRateSpecification);
	}

}
