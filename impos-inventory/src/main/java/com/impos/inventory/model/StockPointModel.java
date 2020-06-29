package com.impos.inventory.model;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;
import com.impos.inventory.domain.ProductSkuBranchBatchStockPoint;
import com.impos.inventory.domain.ProductSkuBranchStockPoint;
import com.impos.inventory.domain.StockLogItems;

@Component("stockPointModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StockPointModel extends AbstractModel {

	private String name, description;
	private String companyBranchId;
	private String companyId;
	private String isActive;
	private List<StockLogItems> stockLogItems;
	private List<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPoints;
	private List<ProductSkuBranchStockPoint> productSkuBranchStockPoints;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyBranchId() {
		return companyBranchId;
	}

	public void setCompanyBranchId(String companyBranchId) {
		this.companyBranchId = companyBranchId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public List<StockLogItems> getStockLogItems() {
		return stockLogItems;
	}

	public void setStockLogItems(List<StockLogItems> stockLogItems) {
		this.stockLogItems = stockLogItems;
	}

	public List<ProductSkuBranchBatchStockPoint> getProductSkuBranchBatchStockPoints() {
		return productSkuBranchBatchStockPoints;
	}

	public void setProductSkuBranchBatchStockPoints(
			List<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPoints) {
		this.productSkuBranchBatchStockPoints = productSkuBranchBatchStockPoints;
	}

	public List<ProductSkuBranchStockPoint> getProductSkuBranchStockPoints() {
		return productSkuBranchStockPoints;
	}

	public void setProductSkuBranchStockPoints(List<ProductSkuBranchStockPoint> productSkuBranchStockPoints) {
		this.productSkuBranchStockPoints = productSkuBranchStockPoints;
	}

}
