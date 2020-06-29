package com.impos.settings.businessdelegate;

import java.util.Collection;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.settings.businessdelegate.context.TaxGroupRateContext;
import com.impos.settings.domain.TaxGroupRate;
import com.impos.settings.model.TaxGroupRateModel;
import com.impos.settings.service.ITaxGroupRateService;

@Service
public class TaxGroupRateBusinessDelegate  implements IBusinessDelegate<TaxGroupRateModel, TaxGroupRateContext, IKeyBuilder<String>, String>{

	@Autowired
	private ITaxGroupRateService taxGroupRateService;
	@Override
	public TaxGroupRateModel create(TaxGroupRateModel model) {
		TaxGroupRate taxGroupRate = new TaxGroupRate();
		BeanUtils.copyProperties(model, taxGroupRate);
		taxGroupRateService.create(taxGroupRate);
		BeanUtils.copyProperties(taxGroupRate, model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, TaxGroupRateContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaxGroupRateModel edit(IKeyBuilder<String> keyBuilder, TaxGroupRateModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxGroupRateModel edit(IKeyBuilder<String> keyBuilder, TaxGroupRateModel model,
			TaxGroupRateContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxGroupRateModel getByKey(IKeyBuilder<String> keyBuilder, TaxGroupRateContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TaxGroupRateModel> getCollection(TaxGroupRateContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
