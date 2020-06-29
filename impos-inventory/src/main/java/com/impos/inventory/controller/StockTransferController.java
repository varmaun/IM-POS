package com.impos.inventory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.inventory.businessdelegate.context.StockTransferContext;
import com.impos.inventory.model.StockTransferModel;

@RestController
@RequestMapping(value = "stocktransfer", produces = "application/json", consumes = "application/json")
public class StockTransferController {

	private IBusinessDelegate<StockTransferModel, StockTransferContext, IKeyBuilder<String>, String> businessDelegate;

	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<StockTransferModel> createStockTransfer(@RequestBody StockTransferModel model) {
		model = businessDelegate.create(model);
		return new ResponseEntity<StockTransferModel>(model, HttpStatus.CREATED);
	}
	 

}
