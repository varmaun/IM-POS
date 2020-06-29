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
import com.impos.catalogue.businessdelegate.context.BrandContext;
import com.impos.catalogue.model.BrandModel;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/brand", produces = "application/json", consumes = "application/json")

public class BrandController {

	private IBusinessDelegate<BrandModel, BrandContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<BrandContext> brandContextFactory;
	
	@PostMapping(value = "/create")
	public ResponseEntity<BrandModel> createBrand(@RequestBody BrandModel brand) {

		businessDelegate.create(brand);
		return new ResponseEntity<>(brand, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<BrandModel>> getBrand(
			@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "cid", required = false) final String companyId) {
		BrandContext brandContext = brandContextFactory.getObject();
		brandContext.getContextParams().put("status", status);
		brandContext.getContextParams().put("companyId", companyId);
		List<BrandModel> models = (List<BrandModel>) businessDelegate.getCollection(brandContext);
		return new ResponseEntity<>(models, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<BrandModel> editBrand(@PathVariable(value = "id") final String brandId,
			@RequestBody BrandModel brandModel) {
		brandModel = businessDelegate.edit(null, brandModel);
		return new ResponseEntity<>(brandModel, HttpStatus.CREATED);
	}
	
	/**
	 * @param businessDelegate
	 */
	@Resource(name = "brandBusinessDelegate")

	public void setBusinessDelegate(
			final IBusinessDelegate<BrandModel, BrandContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setPartyObjectFactory(final ObjectFactory<BrandContext> brandContextFactory) {
		this.brandContextFactory = brandContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}
	
}
