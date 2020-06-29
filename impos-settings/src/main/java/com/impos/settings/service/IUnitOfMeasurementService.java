package com.impos.settings.service;

import java.util.List;

import com.impos.settings.businessdelegate.context.UnitOfMeasurementContext;
import com.impos.settings.domain.UnitOfMeasurement;

public interface IUnitOfMeasurementService {
	
	UnitOfMeasurement create(UnitOfMeasurement unitOfMeasurement);

	void deleteUnitOfMeasurement(String unitOfMeasurementId);

	UnitOfMeasurement getUnitOfMeasurement(String unitOfMeasurementId);

	List<UnitOfMeasurement> getAll();

	UnitOfMeasurement updateUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement);

	List<UnitOfMeasurement> getAll(UnitOfMeasurementContext context);

	
}
