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
import com.impos.inventory.businessdelegate.context.ProductSkuBranchStockPointContext;
import com.impos.inventory.model.ProductSkuBranchStockPointModel;

/**
 * @author Administrator
 *
 */

@RestController
@RequestMapping(value = "/productSkuBranchStockPoint")
public class ProductSkuBranchStockPointController {

	private IBusinessDelegate<ProductSkuBranchStockPointModel, ProductSkuBranchStockPointContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<ProductSkuBranchStockPointContext> productSkuBranchStockPointContextFactory;

	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<ProductSkuBranchStockPointModel> createProductSkuBranchStockPoint(@RequestBody  ProductSkuBranchStockPointModel productSkuBranchStockPointModel) {
	productSkuBranchStockPointModel =	businessDelegate.create(productSkuBranchStockPointModel);
		return new ResponseEntity<ProductSkuBranchStockPointModel>(productSkuBranchStockPointModel, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public ResponseEntity<ProductSkuBranchStockPointModel> edit(@PathVariable(value = "id") final String productSkuBranchStockPointId,
			@RequestBody  ProductSkuBranchStockPointModel productSkuBranchStockPointModel) {

	productSkuBranchStockPointModel =	businessDelegate.edit(keyBuilderFactory.getObject().withId(productSkuBranchStockPointId), productSkuBranchStockPointModel);
		return new ResponseEntity<ProductSkuBranchStockPointModel>(productSkuBranchStockPointModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<IModelWrapper<Collection<ProductSkuBranchStockPointModel>>> getAll() {
		ProductSkuBranchStockPointContext productSkuBranchStockPointContext = productSkuBranchStockPointContextFactory.getObject();
		productSkuBranchStockPointContext.setAll("all");
		Collection<ProductSkuBranchStockPointModel> productSkuBranchStockPointModels = businessDelegate.getCollection(productSkuBranchStockPointContext);
		IModelWrapper<Collection<ProductSkuBranchStockPointModel>> models = new CollectionModelWrapper<ProductSkuBranchStockPointModel>(
				ProductSkuBranchStockPointModel.class, productSkuBranchStockPointModels);
		return new ResponseEntity<IModelWrapper<Collection<ProductSkuBranchStockPointModel>>>(models, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<ProductSkuBranchStockPointModel> getProductSkuBranchStockPoint(@PathVariable(value = "id") final String productSkuBranchStockPointId) {
		ProductSkuBranchStockPointContext productSkuBranchStockPointContext = productSkuBranchStockPointContextFactory.getObject();

		ProductSkuBranchStockPointModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(productSkuBranchStockPointId),
				productSkuBranchStockPointContext);
		return new ResponseEntity<ProductSkuBranchStockPointModel>(model, HttpStatus.OK);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "productSkuBranchStockPointBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<ProductSkuBranchStockPointModel, ProductSkuBranchStockPointContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setProductSkuBranchStockPointObjectFactory(final ObjectFactory<ProductSkuBranchStockPointContext> productSkuBranchStockPointContextFactory) {
		this.productSkuBranchStockPointContextFactory = productSkuBranchStockPointContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
