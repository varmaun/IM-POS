package com.impos.catalogue.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.impos.catalogue.businessdelegate.context.AttributeContext;
import com.impos.catalogue.model.AttributeModel;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/attribute", produces = "application/json", consumes = "application/json")

public class AttributeController {
	private IBusinessDelegate<AttributeModel,AttributeContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<AttributeContext> attributeContextFactory;
	
	@PostMapping(value = "/create")
	public ResponseEntity<AttributeModel> createAttribute(@RequestBody AttributeModel attribute) {

		businessDelegate.create(attribute);
		return new ResponseEntity<>(attribute, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AttributeModel> getAttribute(@PathVariable(value = "id") final String attributeId) {
		AttributeContext attributeContext = attributeContextFactory.getObject();
		AttributeModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(attributeId), attributeContext);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<AttributeModel>> getAttribute(
			@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "cid", required = false) final String companyId) {
		AttributeContext attributeContext = attributeContextFactory.getObject();
		attributeContext.getContextParams().put("status", status);
		attributeContext.getContextParams().put("companyId", companyId);
		List<AttributeModel> models = (List<AttributeModel>) businessDelegate.getCollection(attributeContext);
		return new ResponseEntity<>(models, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<AttributeModel> editAttribute(@PathVariable(value = "id") final String attributeId,
			@RequestBody AttributeModel attributeModel) {
		attributeModel = businessDelegate.edit(null, attributeModel);
		return new ResponseEntity<>(attributeModel, HttpStatus.CREATED);
	}
	
	/**
	 * @param businessDelegate
	 */
	@Resource(name = "attributeBusinessDelegate")

	public void setBusinessDelegate(
			final IBusinessDelegate<AttributeModel,AttributeContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setPartyObjectFactory(final ObjectFactory<AttributeContext> attributeContextFactory) {
		this.attributeContextFactory = attributeContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}
	

}
