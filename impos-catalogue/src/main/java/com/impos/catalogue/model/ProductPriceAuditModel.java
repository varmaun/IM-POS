package com.impos.catalogue.model;

import java.math.BigDecimal;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("productPriceAuditModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductPriceAuditModel extends AbstractModel{
	
	private String productSkuId;
	private String batchId;
	private BigDecimal mrpSellingPrice;
	private Boolean isActive;
	public String getProductSkuId() {
		return productSkuId;
	}
	public void setProductSkuId(String productSkuId) {
		this.productSkuId = productSkuId;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public BigDecimal getMrpSellingPrice() {
		return mrpSellingPrice;
	}
	public void setMrpSellingPrice(BigDecimal mrpSellingPrice) {
		this.mrpSellingPrice = mrpSellingPrice;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	

}
