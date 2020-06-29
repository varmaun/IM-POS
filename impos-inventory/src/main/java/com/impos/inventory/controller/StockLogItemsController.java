package com.impos.inventory.controller;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.businessdelegate.model.SimpleIdKeyBuilder;
import com.avitcore.model.CollectionModelWrapper;
import com.avitcore.model.IModelWrapper;
import com.impos.inventory.businessdelegate.context.StockLogItemsContext;
import com.impos.inventory.model.StockLogItemsModel;

/**
 * @author Administrator
 *
 */

@RestController
@RequestMapping(value = "/stockLogItems")
public class StockLogItemsController {

	private IBusinessDelegate<StockLogItemsModel, StockLogItemsContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<StockLogItemsContext> stockLogItemsContextFactory;

	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<StockLogItemsModel> createStockLogItems(@RequestBody  StockLogItemsModel stockLogItemsModel) {
	stockLogItemsModel =	businessDelegate.create(stockLogItemsModel);
		return new ResponseEntity<StockLogItemsModel>(stockLogItemsModel, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public ResponseEntity<StockLogItemsModel> edit(@PathVariable(value = "id") final String stockLogItemsId,
			@RequestBody  StockLogItemsModel stockLogItemsModel) {

	stockLogItemsModel =	businessDelegate.edit(keyBuilderFactory.getObject().withId(stockLogItemsId), stockLogItemsModel);
		return new ResponseEntity<StockLogItemsModel>(stockLogItemsModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<IModelWrapper<Collection<StockLogItemsModel>>> getAll() {
		StockLogItemsContext stockLogItemsContext = stockLogItemsContextFactory.getObject();
		stockLogItemsContext.setAll("all");
		Collection<StockLogItemsModel> stockLogItemsModels = businessDelegate.getCollection(stockLogItemsContext);
		IModelWrapper<Collection<StockLogItemsModel>> models = new CollectionModelWrapper<StockLogItemsModel>(
				StockLogItemsModel.class, stockLogItemsModels);
		return new ResponseEntity<IModelWrapper<Collection<StockLogItemsModel>>>(models, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<StockLogItemsModel> getStockLogItems(@PathVariable(value = "id") final String stockLogItemsId) {
		StockLogItemsContext stockLogItemsContext = stockLogItemsContextFactory.getObject();

		StockLogItemsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(stockLogItemsId),
				stockLogItemsContext);
		return new ResponseEntity<StockLogItemsModel>(model, HttpStatus.OK);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "stockLogItemsBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<StockLogItemsModel, StockLogItemsContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setStockLogItemsObjectFactory(final ObjectFactory<StockLogItemsContext> stockLogItemsContextFactory) {
		this.stockLogItemsContextFactory = stockLogItemsContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
