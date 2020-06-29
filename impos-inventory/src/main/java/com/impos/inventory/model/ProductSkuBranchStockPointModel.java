package com.impos.inventory.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;
import com.impos.catalogue.domain.ProductSku;
import com.impos.company.domain.CompanyBranch;
import com.impos.inventory.domain.StockPoint;
import com.impos.settings.domain.UnitOfMeasurement;

@Component("productSkuBranchStockPointModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductSkuBranchStockPointModel extends AbstractModel {

	private String units;
	private String nonSellableUnits;
	private String quantity;
	private String compnayBranchId;
	private String stockPointId;
	private String productSkuId;
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

	public String getCompnayBranchId() {
		return compnayBranchId;
	}

	public void setCompnayBranchId(String compnayBranchId) {
		this.compnayBranchId = compnayBranchId;
	}

	public String getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(String stockPointId) {
		this.stockPointId = stockPointId;
	}

	public String getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(String productSkuId) {
		this.productSkuId = productSkuId;
	}

	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

}
