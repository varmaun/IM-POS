package com.impos.settings.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.settings.businessdelegate.context.UnitOfMeasurementContext;
import com.impos.settings.domain.UnitOfMeasurement;
import com.impos.settings.model.UnitOfMeasurementModel;
import com.impos.settings.service.IUnitOfMeasurementService;

@Service
public class UnitOfMeasurementBusinessDelegate implements IBusinessDelegate<UnitOfMeasurementModel, UnitOfMeasurementContext, IKeyBuilder<String>, String>{

	@Autowired
	private IUnitOfMeasurementService unitOfMeasurementService;
	@Override
	public UnitOfMeasurementModel create(UnitOfMeasurementModel model) {
		UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement();
		converter(model, unitOfMeasurement);
		unitOfMeasurementService.create(unitOfMeasurement);
		converter(unitOfMeasurement, model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, UnitOfMeasurementContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UnitOfMeasurementModel edit(IKeyBuilder<String> keyBuilder, UnitOfMeasurementModel model) {
		if(model!=null && model.getId()!=null) {
//			 existingDepartment = departmentService.getDepartment(model.getId());
			UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement();
			converter(model,unitOfMeasurement);
			unitOfMeasurementService.updateUnitOfMeasurement(unitOfMeasurement);
			converter(unitOfMeasurement,model);
		}
		return model;
	}

	@Override
	public UnitOfMeasurementModel edit(IKeyBuilder<String> keyBuilder, UnitOfMeasurementModel model,
			UnitOfMeasurementContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitOfMeasurementModel getByKey(IKeyBuilder<String> keyBuilder, UnitOfMeasurementContext context) {
		UnitOfMeasurement unitOfMeasurement = unitOfMeasurementService.getUnitOfMeasurement(keyBuilder.build().toString());
		UnitOfMeasurementModel model = new UnitOfMeasurementModel();
		converter(unitOfMeasurement,model);
		return model;
	}

	@Override
	public Collection<UnitOfMeasurementModel> getCollection(UnitOfMeasurementContext context) {
		List<UnitOfMeasurementModel> models = new ArrayList<UnitOfMeasurementModel>();
		for(UnitOfMeasurement unitOfMeasurement:unitOfMeasurementService.getAll(context)) {
			UnitOfMeasurementModel model = new UnitOfMeasurementModel();
			converter(unitOfMeasurement,model);
			models.add(model);
		}
		return models;
	}
	private void converter(UnitOfMeasurement source, UnitOfMeasurementModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(UnitOfMeasurementModel source, UnitOfMeasurement target) {

		BeanUtils.copyProperties(source, target);
	}

}
