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
import com.impos.inventory.businessdelegate.context.StockMovementContext;
import com.impos.inventory.model.StockMovementModel;

@RestController
@RequestMapping(value = "stockmovement", produces = "application/json", consumes = "application/json")
public class StockMovementController {

	private IBusinessDelegate<StockMovementModel, StockMovementContext, IKeyBuilder<String>, String> businessDelegate;

	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<StockMovementModel> createStockMovement(@RequestBody StockMovementModel model) {
		model = businessDelegate.create(model);
		return new ResponseEntity<StockMovementModel>(model, HttpStatus.CREATED);
	}

}
