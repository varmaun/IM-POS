package com.impos.settings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.impos.settings.domain.TaxGroupRate;
import com.impos.settings.repository.TaxGroupRateRepository;

/**
 * @author Jay
 *
 */
@Component
public class TaxGroupRateService implements ITaxGroupRateService{
	
	@Autowired
	private TaxGroupRateRepository taxGroupRateRepository;
	@Override
	public TaxGroupRate create(TaxGroupRate taxGroupRate) {
		taxGroupRateRepository.save(taxGroupRate);
		return taxGroupRate;
	}

	@Override
	public void deleteTaxGroupRate(String taxGroupRateId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaxGroupRate getTaxGroupRate(String taxGroupRateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaxGroupRate> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxGroupRate updateTaxGroupRate(TaxGroupRate taxGroupRate) {
		// TODO Auto-generated method stub
		return null;
	}

}
