package com.impos.settings.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.settings.businessdelegate.context.TaxGroupContext;
import com.impos.settings.domain.TaxGroup;
import com.impos.settings.repository.TaxGroupRepository;

/**
 * @author Jay
 *
 */
@Component
public class TaxGroupService implements ITaxGroupService{
	
	@Autowired
	private TaxGroupRepository taxGroupRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;
	@Override
	public TaxGroup create(TaxGroup taxGroup) {
		System.out.println(taxGroup.getTaxGroupRates().get(0).getTaxRate().getId());
		taxGroupRepository.save(taxGroup);
		return taxGroup;
	}

	@Override
	public void deleteTaxGroup(String taxGroupId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaxGroup getTaxGroup(String taxGroupId) {
		return taxGroupRepository.findById(taxGroupId).orElse(null);
	}

	@Override
	public List<TaxGroup> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxGroup updateTaxGroup(TaxGroup taxGroup) {
		if(taxGroup!=null) {
			TaxGroup tg = getTaxGroup(taxGroup.getId());
			try {
				nullAwareBeanUtils.copyProperties(tg, taxGroup);
				taxGroupRepository.save(tg);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return taxGroup;
	}

	@Override
	public List<TaxGroup> getAll(TaxGroupContext context) {
		Specification<TaxGroup> taxGroupSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return taxGroupRepository.findAll(taxGroupSpecification);
	}

}
