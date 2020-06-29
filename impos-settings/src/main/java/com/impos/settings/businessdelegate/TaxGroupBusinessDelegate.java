package com.impos.settings.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.settings.businessdelegate.context.TaxGroupContext;
import com.impos.settings.domain.Department;
import com.impos.settings.domain.TaxGroup;
import com.impos.settings.domain.TaxGroupRate;
import com.impos.settings.domain.TaxRate;
import com.impos.settings.model.DepartmentModel;
import com.impos.settings.model.TaxGroupModel;
import com.impos.settings.model.TaxGroupRateModel;
import com.impos.settings.service.ITaxGroupService;

@Service
public class TaxGroupBusinessDelegate
		implements IBusinessDelegate<TaxGroupModel, TaxGroupContext, IKeyBuilder<String>, String> {

	@Autowired
	private ITaxGroupService taxGroupService;

	@Override
	public TaxGroupModel create(TaxGroupModel model) {
		TaxGroup taxGroup = new TaxGroup();
		converter(model, taxGroup);
		taxGroupService.create(taxGroup);
		converter(taxGroup, model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, TaxGroupContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public TaxGroupModel edit(IKeyBuilder<String> keyBuilder, TaxGroupModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxGroupModel edit(IKeyBuilder<String> keyBuilder, TaxGroupModel model, TaxGroupContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxGroupModel getByKey(IKeyBuilder<String> keyBuilder, TaxGroupContext context) {
		TaxGroup taxGroup = taxGroupService.getTaxGroup(keyBuilder.build().toString());
		TaxGroupModel model = new TaxGroupModel();
		converter(taxGroup, model);
		return model;
	}

	@Override
	public Collection<TaxGroupModel> getCollection(TaxGroupContext context) {
		List<TaxGroupModel> models = new ArrayList<TaxGroupModel>();
		for(TaxGroup taxGroup:taxGroupService.getAll(context)) {
			TaxGroupModel model = new TaxGroupModel();
			converter(taxGroup,model);
			models.add(model);
		}
		return models;
	}

	private void converter(TaxGroup source, TaxGroupModel target) {

		BeanUtils.copyProperties(source, target);

	}

	private void converter(TaxGroupModel source, TaxGroup target) {

		BeanUtils.copyProperties(source, target);
		if (!CollectionUtils.isEmpty(source.getTaxGroupRateModels())) {
			List<TaxGroupRate> taxGroupRates = new ArrayList<TaxGroupRate>();
			for (TaxGroupRateModel tgModel : source.getTaxGroupRateModels()) {
				TaxGroupRate taxGroupRate = new TaxGroupRate();
				BeanUtils.copyProperties(tgModel, taxGroupRate);
				if (tgModel.getTaxRateId() != null) {
					TaxRate tr = new TaxRate();
					if (tgModel.getTaxRateId() != null) {
						tr.setId(tgModel.getTaxRateId());
					}

					taxGroupRate.setTaxGroup(target);
					taxGroupRate.setTaxRate(tr);
				}
				taxGroupRates.add(taxGroupRate);
			}
			target.setTaxGroupRates(taxGroupRates);
		}
	}

}
