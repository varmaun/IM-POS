package com.impos.catalogue.service;

import java.util.List;

import com.impos.catalogue.businessdelegate.context.ProductContext;
import com.impos.catalogue.domain.Product;

public interface IProductService {
	
	Product create(Product product);

	void deleteProduct(String productId);

	Product getProduct(String productId);

	List<Product> getAll();

	Product updateProduct(Product product);

	List<Product> getAll(ProductContext context);

}
