package com.impos.catalogue.service;

import java.util.List;

import com.impos.catalogue.businessdelegate.context.ProductAttributesContext;
import com.impos.catalogue.domain.ProductAttributes;

public interface IProductAttributesService {

	ProductAttributes create(ProductAttributes productAttributes);

	void deleteProductAttributes(String productAttributesId);

	ProductAttributes getProductAttributes(String productAttributesId);

	List<ProductAttributes> getAll();

	ProductAttributes updateProductAttributes(ProductAttributes productAttributes);

	List<ProductAttributes> getAll(ProductAttributesContext context);
}
