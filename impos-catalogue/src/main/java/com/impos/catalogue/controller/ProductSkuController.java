package com.impos.catalogue.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.avitcore.businessdelegate.model.SimpleIdKeyBuilder;
import com.impos.catalogue.businessdelegate.context.ProductSkuContext;
import com.impos.catalogue.model.ProductSkuModel;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/productSku", produces = MediaType.ALL_VALUE, consumes = MediaType.ALL_VALUE)
public class ProductSkuController {

	private IBusinessDelegate<ProductSkuModel, ProductSkuContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<ProductSkuContext> productSkuContextFactory;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductSkuModel> getProductSkuById(@PathVariable("id") final String productSkuId) {

		ProductSkuModel skuProduct = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(productSkuId),
				productSkuContextFactory.getObject());

		return new ResponseEntity<>(skuProduct, HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<ProductSkuModel> createProductSku(@RequestBody ProductSkuModel productSkuModel) {
		productSkuModel = businessDelegate.create(productSkuModel);
		return new ResponseEntity<ProductSkuModel>(productSkuModel, HttpStatus.OK);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "productSkuBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<ProductSkuModel, ProductSkuContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setProductSkuObjectFactory(final ObjectFactory<ProductSkuContext> productSkuContextFactory) {
		this.productSkuContextFactory = productSkuContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}
}
