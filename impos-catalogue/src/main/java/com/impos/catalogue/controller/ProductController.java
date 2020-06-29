package com.impos.catalogue.controller;

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
import com.impos.catalogue.businessdelegate.context.ProductContext;
import com.impos.catalogue.model.ProductModel;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/product", produces = MediaType.ALL_VALUE, consumes = MediaType.ALL_VALUE)
public class ProductController {

	private IBusinessDelegate<ProductModel, ProductContext, IKeyBuilder<String>, String> businessDelegate;
	private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
	private ObjectFactory<ProductContext> productContextFactory;

	@PostMapping(value = "/create")
	public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel product) {

		businessDelegate.create(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductModel> getProduct(@PathVariable(value = "id") final String productId) {
		ProductContext context = productContextFactory.getObject();
		ProductModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(productId), context);
		return new ResponseEntity<ProductModel>(model, HttpStatus.OK);

	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<ProductModel>> getProduct(
			@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "cid", required = false) final String companyId) {
		ProductContext context = productContextFactory.getObject();
		context.getContextParams().put("status", status);
		context.getContextParams().put("companyId", companyId);
		List<ProductModel> models = (List<ProductModel>) businessDelegate.getCollection(context);
		return new ResponseEntity<List<ProductModel>>(models, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}/edit")
	public ResponseEntity<ProductModel> editProduct(@PathVariable(value = "id") final String productId,
			@RequestBody ProductModel productModel) {
		productModel = businessDelegate.edit(null, productModel);
		return new ResponseEntity<>(productModel, HttpStatus.CREATED);
	}

	/**
	 * @param businessDelegate
	 */
	@Resource(name = "productBusinessDelegate")
	public void setBusinessDelegate(
			final IBusinessDelegate<ProductModel, ProductContext, IKeyBuilder<String>, String> businessDelegate) {
		this.businessDelegate = businessDelegate;
	}

	@Autowired
	public void setProductObjectFactory(final ObjectFactory<ProductContext> productContextFactory) {
		this.productContextFactory = productContextFactory;
	}

	/**
	 * @param factory
	 */
	@Resource
	public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
		keyBuilderFactory = factory;
	}

}
