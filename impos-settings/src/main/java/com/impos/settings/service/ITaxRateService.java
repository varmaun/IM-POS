package com.impos.settings.service;

import java.util.List;

import com.impos.settings.businessdelegate.context.TaxRateContext;
import com.impos.settings.domain.TaxRate;

public interface ITaxRateService {

	TaxRate create(TaxRate taxRate);

	void deleteTaxRate(String taxRateId);

	TaxRate getTaxRate(String taxRateId);

	List<TaxRate> getAll();

	TaxRate updateTaxRate(TaxRate taxRate);

	List<TaxRate> getAll(TaxRateContext context);

}
