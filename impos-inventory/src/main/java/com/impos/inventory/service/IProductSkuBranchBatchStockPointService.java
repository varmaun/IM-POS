package com.impos.inventory.service;

import java.util.List;

import com.impos.inventory.domain.ProductSkuBranchBatchStockPoint;
/*
*@Author varma
*/
public interface IProductSkuBranchBatchStockPointService {
	
	ProductSkuBranchBatchStockPoint create(ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoint);

	void deleteProductSkuBranchBatchStockPoint(String productSkuBranchBatchStockPointId);

	ProductSkuBranchBatchStockPoint getProductSkuBranchBatchStockPoint(String productSkuBranchBatchStockPointId);

	List<ProductSkuBranchBatchStockPoint> getAll();

	ProductSkuBranchBatchStockPoint updateProductSkuBranchBatchStockPoint(ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoint);
	
	ProductSkuBranchBatchStockPoint getProductSkuBranchBatchStockPointByContext(String batchId,
			String companyBranchId, String stockPointId, String uomId, String productSkuId);
}
