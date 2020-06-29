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
public class ProductSkuBranchStockPointContext implements IBusinessDelegateContext {

	private String productSkuBranchStockPointId;
	private String all;
	
	public String getProductSkuBranchStockPointId() {
		return productSkuBranchStockPointId;
	}

	public void setProductSkuBranchStockPointId(String productSkuBranchStockPointId) {
		this.productSkuBranchStockPointId = productSkuBranchStockPointId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
