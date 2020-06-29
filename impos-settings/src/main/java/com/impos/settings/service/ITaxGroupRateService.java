package com.impos.settings.service;

import java.util.List;

import com.impos.settings.domain.TaxGroupRate;

public interface ITaxGroupRateService {
	
	TaxGroupRate create(TaxGroupRate taxGroupRate);

	void deleteTaxGroupRate(String taxGroupRateId);

	TaxGroupRate getTaxGroupRate(String taxGroupRateId);

	List<TaxGroupRate> getAll();

	TaxGroupRate updateTaxGroupRate(TaxGroupRate taxGroupRate);

}
