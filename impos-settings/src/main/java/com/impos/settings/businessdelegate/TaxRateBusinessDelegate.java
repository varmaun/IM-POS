package com.impos.settings.businessdelegate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.settings.businessdelegate.context.TaxRateContext;
import com.impos.settings.domain.TaxRate;
import com.impos.settings.model.TaxRateModel;
import com.impos.settings.service.ITaxRateService;

@Service
public class TaxRateBusinessDelegate  implements IBusinessDelegate<TaxRateModel, TaxRateContext, IKeyBuilder<String>, String>{

	@Autowired
	private ITaxRateService taxRateService;
	@Override
	public TaxRateModel create(TaxRateModel model) {
		TaxRate  taxRate = new TaxRate();
		converter(model,taxRate);
		 taxRateService.create( taxRate);
		 converter(taxRate,model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, TaxRateContext context) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public TaxRateModel edit(IKeyBuilder<String> keyBuilder, TaxRateModel model) {
		
		if(model!=null && model.getId()!=null) {
			TaxRate taxRate = new TaxRate();
			converter(model,taxRate);
			taxRateService.updateTaxRate(taxRate);
			converter(taxRate,model);
		}
		return model;
	}

	@Override
	public TaxRateModel edit(IKeyBuilder<String> keyBuilder, TaxRateModel model, TaxRateContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxRateModel getByKey(IKeyBuilder<String> keyBuilder, TaxRateContext context) {
		TaxRate taxRate = taxRateService.getTaxRate(keyBuilder.build().toString());
		TaxRateModel model = new TaxRateModel();
		converter(taxRate,model);
		return model;
	}

	@Override
	public Collection<TaxRateModel> getCollection(TaxRateContext context) {
		List<TaxRateModel> models = new ArrayList<TaxRateModel>();
		for(TaxRate taxRate:taxRateService.getAll(context)) {
			TaxRateModel model = new TaxRateModel();
			converter(taxRate,model);
			models.add(model);
		}
		return models;
	}
	
	private void converter(TaxRate source, TaxRateModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(TaxRateModel source, TaxRate target) {

		BeanUtils.copyProperties(source, target);
		target.setRate(new BigDecimal(source.getRate()));
	}

}
