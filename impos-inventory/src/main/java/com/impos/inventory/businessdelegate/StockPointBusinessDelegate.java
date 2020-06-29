package com.impos.inventory.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.inventory.businessdelegate.context.StockPointContext;
import com.impos.inventory.converters.StockPointModelToStockPointConverter;
import com.impos.inventory.converters.StockPointToStockPointModelConverter;
import com.impos.inventory.domain.StockPoint;
import com.impos.inventory.model.StockPointModel;
import com.impos.inventory.service.IStockPointService;

/*
*@Author varma
*/

@Service

public class StockPointBusinessDelegate
		implements IBusinessDelegate<StockPointModel, StockPointContext, IKeyBuilder<String>, String> {

	@Autowired
	private IStockPointService stockPointService;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private StockPointToStockPointModelConverter domainToModelConverter;
	@Autowired
	private StockPointModelToStockPointConverter modelToDomainConverter;

	@Override
	@Transactional
	public StockPointModel create(StockPointModel model) {
		StockPoint stockPoint = stockPointService.create((StockPoint) modelToDomainConverter.convert(model));
		model = convertToStockPointModel(stockPoint);
		return model;
	}

	private StockPointModel convertToStockPointModel(StockPoint stockPoint) {
		return (StockPointModel) domainToModelConverter.convert(stockPoint);
	}

	/*
	 * private StockPoint convertToStockPoint(StockPointModel model) { return
	 * (StockPoint) modelToDomainConverter.convert(model); }
	 */

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, StockPointContext context) {

	}

	@Override
	public StockPointModel edit(IKeyBuilder<String> keyBuilder, StockPointModel model) {
		StockPoint stockPoint = stockPointService.getStockPoint(keyBuilder.build().toString());
		stockPoint = stockPointService.updateStockPoint(
				(StockPoint) modelToDomainConverter.convert(model));
		model = convertToStockPointModel(stockPoint);

		return model;
	}

	@Override
	public StockPointModel getByKey(IKeyBuilder<String> keyBuilder, StockPointContext context) {
		StockPoint stockPoint = stockPointService.getStockPoint(keyBuilder.build().toString());
		StockPointModel model = convertToStockPointModel(stockPoint);
		return model;
	}

	@Override
	public Collection<StockPointModel> getCollection(StockPointContext context) {
		List<StockPoint> stockPoint = new ArrayList<StockPoint>();
		
		List<StockPointModel> stockPointModels = (List<StockPointModel>) conversionService.convert(stockPoint,
				TypeDescriptor.forObject(stockPoint),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StockPointModel.class)));
		return stockPointModels;
	}

	@Override
	public StockPointModel edit(IKeyBuilder<String> keyBuilder, StockPointModel model, StockPointContext context) {
		return null;
	}

}
