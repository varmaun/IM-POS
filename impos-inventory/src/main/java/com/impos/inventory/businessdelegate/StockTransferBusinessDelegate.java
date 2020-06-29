package com.impos.inventory.businessdelegate;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.inventory.businessdelegate.context.StockTransferContext;
import com.impos.inventory.model.StockTransferModel;
import com.impos.inventory.service.ProductSkuBranchBatchStockPointService;
import com.impos.inventory.service.ProductSkuBranchStockPointService;
import com.impos.inventory.service.StockLogsService;

@Service
public class StockTransferBusinessDelegate
		implements IBusinessDelegate<StockTransferModel, StockTransferContext, IKeyBuilder<String>, String> {

	@Autowired
	private ProductSkuBranchBatchStockPointService productSkuBranchBSPointService;
	@Autowired
	private ProductSkuBranchStockPointService productSkuBranchSPointService;
	@Autowired
	private StockLogsService stockLogsService;

	@Override
	public StockTransferModel create(StockTransferModel model) {
		return null;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, StockTransferContext context) {

	}

	@Override
	public StockTransferModel edit(IKeyBuilder<String> keyBuilder, StockTransferModel model) {
		return null;
	}

	@Override
	public StockTransferModel edit(IKeyBuilder<String> keyBuilder, StockTransferModel model,
			StockTransferContext context) {
		return null;
	}

	@Override
	public StockTransferModel getByKey(IKeyBuilder<String> keyBuilder, StockTransferContext context) {
		return null;
	}

	@Override
	public Collection<StockTransferModel> getCollection(StockTransferContext context) {
		return null;
	}

}
