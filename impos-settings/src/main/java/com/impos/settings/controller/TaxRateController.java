package com.impos.settings.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.businessdelegate.model.SimpleIdKeyBuilder;
import com.impos.settings.businessdelegate.context.DepartmentContext;
import com.impos.settings.businessdelegate.context.TaxRateContext;
import com.impos.settings.model.DepartmentModel;
import com.impos.settings.model.TaxRateModel;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/taxRate", produces = {MediaType.ALL_VALUE}, consumes = {MediaType.ALL_VALUE})
public class TaxRateController {
	
	private IBusinessDelegate<TaxRateModel, TaxRateContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<TaxRateContext> taxRateContextFactory;
	

	@PostMapping(value="/create")
	public ResponseEntity<TaxRateModel> createTaxRate(@RequestBody TaxRateModel taxRate){
		
		businessDelegate.create(taxRate);
		return new ResponseEntity<>(taxRate, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TaxRateModel> getTaxRate(@PathVariable(value = "id") final String taxRateId) {
		TaxRateContext taxRateContext = taxRateContextFactory.getObject();
		TaxRateModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(taxRateId), taxRateContext);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<TaxRateModel>> getTaxRates(
			@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "cid", required = false) final String companyId) {
		TaxRateContext taxRateContext = taxRateContextFactory.getObject();
		taxRateContext.getContextParams().put("status", status);
		taxRateContext.getContextParams().put("companyId", companyId);
		List<TaxRateModel> models = (List<TaxRateModel>) businessDelegate.getCollection(taxRateContext);
		return new ResponseEntity<>(models, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<TaxRateModel> editTaxRate(@PathVariable(value = "id") final String taxRateId,
			@RequestBody TaxRateModel taxRateModel) {
		taxRateModel = businessDelegate.edit(null, taxRateModel);
		return new ResponseEntity<>(taxRateModel, HttpStatus.CREATED);
	}
	/**
	 * @param businessDelegate
	 */
	@Resource(name = "taxRateBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<TaxRateModel, TaxRateContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setTaxRateObjectFactory(final ObjectFactory<TaxRateContext> taxRateContextFactory) {
		this.taxRateContextFactory = taxRateContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
