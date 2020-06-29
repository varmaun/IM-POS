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
import com.impos.inventory.businessdelegate.context.StockLogsContext;
import com.impos.inventory.converters.StockLogsModelToStockLogsConverter;
import com.impos.inventory.converters.StockLogsToStockLogsModelConverter;
import com.impos.inventory.domain.StockLogs;
import com.impos.inventory.model.StockLogsModel;
import com.impos.inventory.service.IStockLogsService;

/*
*@Author varma
*/

@Service

public class StockLogsBusinessDelegate
		implements IBusinessDelegate<StockLogsModel, StockLogsContext, IKeyBuilder<String>, String> {

	@Autowired
	private IStockLogsService stockLogsService;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private StockLogsModelToStockLogsConverter modelToDomainConverter;
	@Autowired
	private StockLogsToStockLogsModelConverter domainToModelConverter;

	@Override
	@Transactional
	public StockLogsModel create(StockLogsModel model) {
		StockLogs stockLogs = stockLogsService.create((StockLogs) modelToDomainConverter.convert(model));
		model = convertToStockLogsModel(stockLogs);
		return model;
	}

	private StockLogsModel convertToStockLogsModel(StockLogs stockLogs) {
		return (StockLogsModel) domainToModelConverter.convert(stockLogs);
	}

	private StockLogs convertToStockLogs(StockLogsModel model) {
		return (StockLogs) modelToDomainConverter.convert(model);
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, StockLogsContext context) {

	}

	@Override
	public StockLogsModel edit(IKeyBuilder<String> keyBuilder, StockLogsModel model) {
		StockLogs stockLogs = stockLogsService.getStockLogs(keyBuilder.build().toString());
		stockLogs = stockLogsService.updateStockLogs((StockLogs) convertToStockLogs(model));
		model = convertToStockLogsModel(stockLogs);

		return model;
	}

	@Override
	public StockLogsModel getByKey(IKeyBuilder<String> keyBuilder, StockLogsContext context) {
		StockLogs stockLogs = stockLogsService.getStockLogs(keyBuilder.build().toString());
		StockLogsModel model = domainToModelConverter.convert(stockLogs);
		return model;
	}

	@Override
	public Collection<StockLogsModel> getCollection(StockLogsContext context) {
		List<StockLogs> stockLogs = new ArrayList<StockLogs>();

		List<StockLogsModel> stockLogsModels = (List<StockLogsModel>) conversionService.convert(stockLogs,
				TypeDescriptor.forObject(stockLogs),
				TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StockLogsModel.class)));
		return stockLogsModels;
	}

	@Override
	public StockLogsModel edit(IKeyBuilder<String> keyBuilder, StockLogsModel model, StockLogsContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
