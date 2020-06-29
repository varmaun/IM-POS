package com.impos.settings.service;

import java.util.List;

import com.impos.settings.businessdelegate.context.TaxGroupContext;
import com.impos.settings.domain.TaxGroup;

public interface ITaxGroupService {
	
	TaxGroup create(TaxGroup taxGroup);

	void deleteTaxGroup(String taxGroupId);

	TaxGroup getTaxGroup(String taxGroupId);

	List<TaxGroup> getAll();

	TaxGroup updateTaxGroup(TaxGroup taxGroup);

	List<TaxGroup> getAll(TaxGroupContext context);

}
