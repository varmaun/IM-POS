package com.impos.inventory.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("productSkuBranchBatchStockPointModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductSkuBranchBatchStockPointModel extends AbstractModel {

	private String units;
	private String nonSellableUnits;
	private String quantity;
	private String productSkuId;
	private String companyBranchId;
	private String batchId;
	private String stockPointId;
	private String uomId;

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getNonSellableUnits() {
		return nonSellableUnits;
	}

	public void setNonSellableUnits(String nonSellableUnits) {
		this.nonSellableUnits = nonSellableUnits;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(String productSkuId) {
		this.productSkuId = productSkuId;
	}

	public String getCompanyBranchId() {
		return companyBranchId;
	}

	public void setCompanyBranchId(String companyBranchId) {
		this.companyBranchId = companyBranchId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(String stockPointId) {
		this.stockPointId = stockPointId;
	}

	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

}
