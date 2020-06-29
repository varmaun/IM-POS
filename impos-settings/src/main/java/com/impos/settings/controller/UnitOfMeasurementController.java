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
import com.impos.settings.businessdelegate.context.UnitOfMeasurementContext;
import com.impos.settings.model.UnitOfMeasurementModel;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/unitOfMeasurement", produces = {MediaType.ALL_VALUE}, consumes = {MediaType.ALL_VALUE})
public class UnitOfMeasurementController {
	
	private IBusinessDelegate<UnitOfMeasurementModel, UnitOfMeasurementContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<UnitOfMeasurementContext> unitOfMeasurementContextFactory;
	
	
	@PostMapping(value="/create")
	public ResponseEntity<UnitOfMeasurementModel> createUnitOfMeasurement(@RequestBody UnitOfMeasurementModel unitOfMeasurement){
		
		businessDelegate.create(unitOfMeasurement);
		return new ResponseEntity<>(unitOfMeasurement, HttpStatus.CREATED);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<UnitOfMeasurementModel> getUnitOfMeasurement(@PathVariable("id") final String unitOfMeasurementId) {
		UnitOfMeasurementContext context = unitOfMeasurementContextFactory.getObject();
		UnitOfMeasurementModel unitOfMeasurementModel = businessDelegate
				.getByKey(keyBuilderFactory.getObject().withId(unitOfMeasurementId), context);

		return new ResponseEntity<UnitOfMeasurementModel>(unitOfMeasurementModel, HttpStatus.OK);

	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<UnitOfMeasurementModel>> geUnitOfMeasurements(
			@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "cid", required = false) final String companyId,
			@RequestParam(value = "puid",required =false)final String parentUnitId) {
		UnitOfMeasurementContext context = unitOfMeasurementContextFactory.getObject();
		context.getContextParams().put("status", status);
		context.getContextParams().put("companyId", companyId);
		context.getContextParams().put("parentUnitId", parentUnitId);
		List<UnitOfMeasurementModel> models = (List<UnitOfMeasurementModel>) businessDelegate.getCollection(context);
		return new ResponseEntity<List<UnitOfMeasurementModel>>(models, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<UnitOfMeasurementModel> editUnitOfMeasurement(@PathVariable(value = "id") final String unitOfMeasurementId,
			@RequestBody UnitOfMeasurementModel unitOfMeasurementModel) {
		unitOfMeasurementModel = businessDelegate.edit(null, unitOfMeasurementModel);
		return new ResponseEntity<>(unitOfMeasurementModel, HttpStatus.CREATED);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "unitOfMeasurementBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<UnitOfMeasurementModel, UnitOfMeasurementContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setUnitOfMeasurementObjectFactory(final ObjectFactory<UnitOfMeasurementContext> unitOfMeasurementContextFactory) {
		this.unitOfMeasurementContextFactory = unitOfMeasurementContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
