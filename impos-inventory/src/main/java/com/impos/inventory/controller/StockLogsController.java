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
import com.impos.inventory.businessdelegate.context.StockLogsContext;
import com.impos.inventory.model.StockLogsModel;

/**
 * @author Administrator
 *
 */

@RestController
@RequestMapping(value = "/stockLogs")
public class StockLogsController {

	private IBusinessDelegate<StockLogsModel, StockLogsContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<StockLogsContext> stockLogsContextFactory;

	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<StockLogsModel> createStockLogs(@RequestBody StockLogsModel stockLogsModel) {
		stockLogsModel = businessDelegate.create(stockLogsModel);
		return new ResponseEntity<StockLogsModel>(stockLogsModel, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public ResponseEntity<StockLogsModel> edit(@PathVariable(value = "id") final String stockLogsId,
			@RequestBody StockLogsModel stockLogsModel) {

		stockLogsModel = businessDelegate.edit(keyBuilderFactory.getObject().withId(stockLogsId), stockLogsModel);
		return new ResponseEntity<StockLogsModel>(stockLogsModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<IModelWrapper<Collection<StockLogsModel>>> getAll() {
		StockLogsContext stockLogsContext = stockLogsContextFactory.getObject();
		stockLogsContext.setAll("all");
		Collection<StockLogsModel> stockLogsModels = businessDelegate.getCollection(stockLogsContext);
		IModelWrapper<Collection<StockLogsModel>> models = new CollectionModelWrapper<StockLogsModel>(
				StockLogsModel.class, stockLogsModels);
		return new ResponseEntity<IModelWrapper<Collection<StockLogsModel>>>(models, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<StockLogsModel> getStockLogs(@PathVariable(value = "id") final String stockLogsId) {
		StockLogsContext stockLogsContext = stockLogsContextFactory.getObject();

		StockLogsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(stockLogsId),
				stockLogsContext);
		return new ResponseEntity<StockLogsModel>(model, HttpStatus.OK);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "stockLogsBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<StockLogsModel, StockLogsContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setStockLogsObjectFactory(final ObjectFactory<StockLogsContext> stockLogsContextFactory) {
		this.stockLogsContextFactory = stockLogsContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
