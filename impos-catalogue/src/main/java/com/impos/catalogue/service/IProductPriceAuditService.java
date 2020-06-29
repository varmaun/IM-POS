package com.impos.catalogue.service;

import java.util.List;

import com.impos.catalogue.businessdelegate.context.ProductPriceAuditContext;
import com.impos.catalogue.domain.ProductPriceAudit ;

public interface IProductPriceAuditService {
	
	ProductPriceAudit create(ProductPriceAudit productPriceAudit);

	void deleteProductPriceAudit(String productPriceAuditId);

	ProductPriceAudit getProductPriceAudit(String productPriceAuditId);

	List<ProductPriceAudit> getAll();

	ProductPriceAudit updateProductPriceAudit(ProductPriceAudit productPriceAudit);

	List<ProductPriceAudit> getAll(ProductPriceAuditContext context);

}
