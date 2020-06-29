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
import com.impos.inventory.businessdelegate.context.ProductSkuBranchBatchStockPointContext;
import com.impos.inventory.model.ProductSkuBranchBatchStockPointModel;

/**
 * @author Administrator
 *
 */

@RestController
@RequestMapping(value = "/productSkuBranchBatchStockPoint")
public class ProductSkuBranchBatchStockPointController {

	private IBusinessDelegate<ProductSkuBranchBatchStockPointModel, ProductSkuBranchBatchStockPointContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<ProductSkuBranchBatchStockPointContext> productSkuBranchBatchStockPointContextFactory;

	@RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<ProductSkuBranchBatchStockPointModel> createProductSkuBranchBatchStockPoint(@RequestBody  ProductSkuBranchBatchStockPointModel productSkuBranchBatchStockPointModel) {
	productSkuBranchBatchStockPointModel =	businessDelegate.create(productSkuBranchBatchStockPointModel);
		return new ResponseEntity<ProductSkuBranchBatchStockPointModel>(productSkuBranchBatchStockPointModel, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
	public ResponseEntity<ProductSkuBranchBatchStockPointModel> edit(@PathVariable(value = "id") final String productSkuBranchBatchStockPointId,
			@RequestBody  ProductSkuBranchBatchStockPointModel productSkuBranchBatchStockPointModel) {

	productSkuBranchBatchStockPointModel =	businessDelegate.edit(keyBuilderFactory.getObject().withId(productSkuBranchBatchStockPointId), productSkuBranchBatchStockPointModel);
		return new ResponseEntity<ProductSkuBranchBatchStockPointModel>(productSkuBranchBatchStockPointModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<IModelWrapper<Collection<ProductSkuBranchBatchStockPointModel>>> getAll() {
		ProductSkuBranchBatchStockPointContext productSkuBranchBatchStockPointContext = productSkuBranchBatchStockPointContextFactory.getObject();
		productSkuBranchBatchStockPointContext.setAll("all");
		Collection<ProductSkuBranchBatchStockPointModel> productSkuBranchBatchStockPointModels = businessDelegate.getCollection(productSkuBranchBatchStockPointContext);
		IModelWrapper<Collection<ProductSkuBranchBatchStockPointModel>> models = new CollectionModelWrapper<ProductSkuBranchBatchStockPointModel>(
				ProductSkuBranchBatchStockPointModel.class, productSkuBranchBatchStockPointModels);
		return new ResponseEntity<IModelWrapper<Collection<ProductSkuBranchBatchStockPointModel>>>(models, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
	public ResponseEntity<ProductSkuBranchBatchStockPointModel> getProductSkuBranchBatchStockPoint(@PathVariable(value = "id") final String productSkuBranchBatchStockPointId) {
		ProductSkuBranchBatchStockPointContext productSkuBranchBatchStockPointContext = productSkuBranchBatchStockPointContextFactory.getObject();

		ProductSkuBranchBatchStockPointModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(productSkuBranchBatchStockPointId),
				productSkuBranchBatchStockPointContext);
		return new ResponseEntity<ProductSkuBranchBatchStockPointModel>(model, HttpStatus.OK);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "productSkuBranchBatchStockPointBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<ProductSkuBranchBatchStockPointModel, ProductSkuBranchBatchStockPointContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setProductSkuBranchBatchStockPointObjectFactory(final ObjectFactory<ProductSkuBranchBatchStockPointContext> productSkuBranchBatchStockPointContextFactory) {
		this.productSkuBranchBatchStockPointContextFactory = productSkuBranchBatchStockPointContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
