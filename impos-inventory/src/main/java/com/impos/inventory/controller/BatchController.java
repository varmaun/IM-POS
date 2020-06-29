package com.impos.inventory.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.businessdelegate.model.SimpleIdKeyBuilder;
import com.impos.inventory.businessdelegate.context.BatchContext;
import com.impos.inventory.model.BatchModel;

/**
 * @author Administrator
 *
 */

@RestController
@RequestMapping(value = "/batch", produces = "application/json", consumes = "application/json")
public class BatchController {

	private IBusinessDelegate<BatchModel, BatchContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<BatchContext> batchContextFactory;

	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<BatchModel> createBatch(@RequestBody @Validated BatchModel batchModel) {
		
		batchModel = businessDelegate.create(batchModel);
		return new ResponseEntity<BatchModel>(batchModel, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public ResponseEntity<BatchModel> edit(@PathVariable(value = "id") final String batchId,
			@RequestBody BatchModel batchModel) {

		batchModel = businessDelegate.edit(keyBuilderFactory.getObject().withId(batchId), batchModel);
		return new ResponseEntity<BatchModel>(batchModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<Collection<BatchModel>> getAll() {
		BatchContext batchContext = batchContextFactory.getObject();
		batchContext.setAll("all");
		Collection<BatchModel> batchModels = businessDelegate.getCollection(batchContext);
		return new ResponseEntity<Collection<BatchModel>>(batchModels, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<BatchModel> getBatch(@PathVariable(value = "id") final String batchId) {
		BatchContext batchContext = batchContextFactory.getObject();
		BatchModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(batchId), batchContext);
		return new ResponseEntity<BatchModel>(model, HttpStatus.OK);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "batchBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<BatchModel, BatchContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setBatchObjectFactory(final ObjectFactory<BatchContext> batchContextFactory) {
		this.batchContextFactory = batchContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
