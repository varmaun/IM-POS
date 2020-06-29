package com.impos.inventory.businessdelegate.context;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.businessdelegate.context.IBusinessDelegateContext;
/*
*@Author varma
*/
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductSkuBranchBatchStockPointContext implements IBusinessDelegateContext {

	private String productSkuBranchBatchStockPointId;
	private String all;
	
	public String getProductSkuBranchBatchStockPointId() {
		return productSkuBranchBatchStockPointId;
	}

	public void setProductSkuBranchBatchStockPointId(String productSkuBranchBatchStockPointId) {
		this.productSkuBranchBatchStockPointId = productSkuBranchBatchStockPointId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
