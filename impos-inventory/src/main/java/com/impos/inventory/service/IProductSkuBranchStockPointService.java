package com.impos.inventory.service;

import java.util.List;

import com.impos.inventory.domain.ProductSkuBranchStockPoint;

/*
*@Author varma
*/
public interface IProductSkuBranchStockPointService {

	ProductSkuBranchStockPoint create(ProductSkuBranchStockPoint productSkuBranchStockPoint);

	void deleteProductSkuBranchStockPoint(String productSkuBranchStockPointId);

	ProductSkuBranchStockPoint getProductSkuBranchStockPoint(String productSkuBranchStockPointId);

	List<ProductSkuBranchStockPoint> getAll();

	ProductSkuBranchStockPoint updateProductSkuBranchStockPoint(ProductSkuBranchStockPoint productSkuBranchStockPoint);

	ProductSkuBranchStockPoint getProductSkuBranchStockPointByContext(String companyBranchId, String fromStockPoint,
			String uomId, String productSkuId);
}
