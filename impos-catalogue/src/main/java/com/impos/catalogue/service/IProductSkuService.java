package com.impos.catalogue.service;

import java.util.List;

import com.impos.catalogue.businessdelegate.context.ProductSkuContext;
import com.impos.catalogue.domain.ProductSku;

public interface IProductSkuService {
	
	ProductSku create(ProductSku productSku);

	void deleteProductSku(String productSkuId);

	ProductSku getProductSku(String productSkuId);

	List<ProductSku> getAll();

	ProductSku updateProductSku(ProductSku productSku);

	List<ProductSku> getAll(ProductSkuContext context);

}
