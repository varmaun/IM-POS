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
import com.impos.inventory.businessdelegate.context.StockPointContext;
import com.impos.inventory.model.StockPointModel;

/**
 * @author Administrator
 *
 */

@RestController
@RequestMapping(value = "/stockPoint")
public class StockPointController {

	private IBusinessDelegate<StockPointModel, StockPointContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<StockPointContext> stockPointContextFactory;

	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<StockPointModel> createStockPoint(@RequestBody  StockPointModel stockPointModel) {
	stockPointModel =	businessDelegate.create(stockPointModel);
		return new ResponseEntity<StockPointModel>(stockPointModel, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public ResponseEntity<StockPointModel> edit(@PathVariable(value = "id") final String stockPointId,
			@RequestBody  StockPointModel stockPointModel) {

	stockPointModel =	businessDelegate.edit(keyBuilderFactory.getObject().withId(stockPointId), stockPointModel);
		return new ResponseEntity<StockPointModel>(stockPointModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<IModelWrapper<Collection<StockPointModel>>> getAll() {
		StockPointContext stockPointContext = stockPointContextFactory.getObject();
		stockPointContext.setAll("all");
		Collection<StockPointModel> stockPointModels = businessDelegate.getCollection(stockPointContext);
		IModelWrapper<Collection<StockPointModel>> models = new CollectionModelWrapper<StockPointModel>(
				StockPointModel.class, stockPointModels);
		return new ResponseEntity<IModelWrapper<Collection<StockPointModel>>>(models, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<StockPointModel> getStockPoint(@PathVariable(value = "id") final String stockPointId) {
		StockPointContext stockPointContext = stockPointContextFactory.getObject();

		StockPointModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(stockPointId),
				stockPointContext);
		return new ResponseEntity<StockPointModel>(model, HttpStatus.OK);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "stockPointBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<StockPointModel, StockPointContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setStockPointObjectFactory(final ObjectFactory<StockPointContext> stockPointContextFactory) {
		this.stockPointContextFactory = stockPointContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
