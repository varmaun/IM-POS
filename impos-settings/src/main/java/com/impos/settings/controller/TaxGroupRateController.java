package com.impos.settings.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.businessdelegate.model.SimpleIdKeyBuilder;
import com.impos.settings.businessdelegate.context.TaxGroupRateContext;
import com.impos.settings.model.TaxGroupRateModel;
@CrossOrigin("*")
@RestController
@RequestMapping(value="/taxGroupRate", produces = {MediaType.ALL_VALUE}, consumes = {MediaType.ALL_VALUE})
public class TaxGroupRateController {
	
	private IBusinessDelegate<TaxGroupRateModel, TaxGroupRateContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<TaxGroupRateContext> taxGroupRateContextFactory;
	

	@PostMapping(value="/create")
	public ResponseEntity< TaxGroupRateModel> createTaxGroupRate(@RequestBody  TaxGroupRateModel  taxGroupRate){
		
		businessDelegate.create( taxGroupRate);
		return new ResponseEntity<>( taxGroupRate, HttpStatus.CREATED);
	}
	
	/**
	 * @param businessDelegate
	 */
	@Resource(name = "taxGroupRateBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<TaxGroupRateModel, TaxGroupRateContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setTaxGroupRateObjectFactory(final ObjectFactory<TaxGroupRateContext> taxGroupRateContextFactory) {
		this.taxGroupRateContextFactory = taxGroupRateContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}
	
	

}
