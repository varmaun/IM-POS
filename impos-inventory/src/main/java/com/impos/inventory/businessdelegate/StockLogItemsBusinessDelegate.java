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
import com.impos.inventory.businessdelegate.context.StockLogItemsContext;
import com.impos.inventory.converters.StockLogItemsModelToStockLogItemsConverter;
import com.impos.inventory.converters.StockLogItemsToStockLogItemsModelConverter;
import com.impos.inventory.domain.StockLogItems;
import com.impos.inventory.model.StockLogItemsModel;
import com.impos.inventory.service.IStockLogItemsService;

/*
*@Author varma
*/

@Service
public class StockLogItemsBusinessDelegate
		implements IBusinessDelegate<StockLogItemsModel, StockLogItemsContext, IKeyBuilder<String>, String> {

	@Autowired
	private IStockLogItemsService stockLogItemsService;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private StockLogItemsModelToStockLogItemsConverter modelToDomainConverter;
	@Autowired
	private StockLogItemsToStockLogItemsModelConverter domainToModelConverter;

	@Override
	@Transactional
	public StockLogItemsModel create(StockLogItemsModel model) {
		StockLogItems stockLogItems = stockLogItemsService.create((StockLogItems) convertToStockLogItems(model));
		model = convertToStockLogItemsModel(stockLogItems);
		return model;
	}

	private StockLogItemsModel convertToStockLogItemsModel(StockLogItems stockLogItems) {
		return (StockLogItemsModel) domainToModelConverter.convert(stockLogItems);
	}

	private StockLogItems convertToStockLogItems(StockLogItemsModel model) {
		return (StockLogItems) modelToDomainConverter.convert(model);
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, StockLogItemsContext context) {

	}

	@Override
	public StockLogItemsModel edit(IKeyBuilder<String> keyBuilder, StockLogItemsModel model) {
		StockLogItems stockLogItems = stockLogItemsService.getStockLogItems(keyBuilder.build().toString());

		stockLogItems = stockLogItemsService.updateStockLogItems(
				(StockLogItems) convertToStockLogItems(model));
		model = convertToStockLogItemsModel(stockLogItems);

		return model;
	}

	@Override
	public StockLogItemsModel getByKey(IKeyBuilder<String> keyBuilder, StockLogItemsContext context) {
		StockLogItems stockLogItems = stockLogItemsService.getStockLogItems(keyBuilder.build().toString());
		StockLogItemsModel model = convertToStockLogItemsModel(stockLogItems);
		return model;
	}

	@Override
	public Collection<StockLogItemsModel> getCollection(StockLogItemsContext context) {
		List<StockLogItems> stockLogItems = new ArrayList<StockLogItems>();

		List<StockLogItemsModel> stockLogItemsModels = (List<StockLogItemsModel>) conversionService.convert(
				stockLogItems, TypeDescriptor.forObject(stockLogItems),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StockLogItemsModel.class)));
		return stockLogItemsModels;
	}

	@Override
	public StockLogItemsModel edit(IKeyBuilder<String> keyBuilder, StockLogItemsModel model,
			StockLogItemsContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
