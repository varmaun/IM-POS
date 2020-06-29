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
import com.impos.settings.businessdelegate.context.TaxGroupContext;
import com.impos.settings.model.TaxGroupModel;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/taxGroup", produces = {MediaType.ALL_VALUE}, consumes = {MediaType.ALL_VALUE})
public class TaxGroupController {

	private IBusinessDelegate<TaxGroupModel, TaxGroupContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<TaxGroupContext> taxGroupContextFactory;

	@PostMapping(value = "/create")
	public ResponseEntity<TaxGroupModel> createTaxGroup(@RequestBody TaxGroupModel taxGroup) {

		businessDelegate.create(taxGroup);
		return new ResponseEntity<>(taxGroup, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TaxGroupModel> getTaxGroup(@PathVariable(value = "id") final String taxGroupId) {
		TaxGroupContext context = taxGroupContextFactory.getObject();
		TaxGroupModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(taxGroupId), context);
		return new ResponseEntity<TaxGroupModel>(model, HttpStatus.OK);

	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<TaxGroupModel>> getTaxGroups(
			@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "cid", required = false) final String companyId) {
		TaxGroupContext context = taxGroupContextFactory.getObject();
		context.getContextParams().put("status", status);
		context.getContextParams().put("companyId", companyId);
		List<TaxGroupModel> models = (List<TaxGroupModel>) businessDelegate.getCollection(context);
		return new ResponseEntity<List<TaxGroupModel>>(models,HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<TaxGroupModel> editTaxGroup(@PathVariable(value = "id") final String taxGroupId,
			@RequestBody TaxGroupModel taxGroupModel) {
		taxGroupModel = businessDelegate.edit(null, taxGroupModel);
		return new ResponseEntity<>(taxGroupModel, HttpStatus.CREATED);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "taxGroupBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<TaxGroupModel, TaxGroupContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setTaxGroupObjectFactory(final ObjectFactory<TaxGroupContext> taxGroupContextFactory) {
		this.taxGroupContextFactory = taxGroupContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
