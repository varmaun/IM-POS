package com.impos.catalogue.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.math.BigDecimal;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;

@Table(name = "product_price_audit")
@Entity
@Component
public class ProductPriceAudit extends AbstractDomain{
	
	private String productSkuId;
	private String batchId;
	private BigDecimal mrpSellingPrice;
	private Boolean isActive;
	
	public ProductPriceAudit() {
		
	}

	public ProductPriceAudit(String productSkuId, String batchId, BigDecimal mrpSellingPrice, Boolean isActive) {
		super();
		this.productSkuId = productSkuId;
		this.batchId = batchId;
		this.mrpSellingPrice = mrpSellingPrice;
		this.isActive = isActive;
	}
	@Column(name = "product_sku_id")
	public String getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(String productSkuId) {
		this.productSkuId = productSkuId;
	}
	@Column(name = "batch_id")
	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	@Column(name = "mrp_selling_price")
	public BigDecimal getMrpSellingPrice() {
		return mrpSellingPrice;
	}

	public void setMrpSellingPrice(BigDecimal mrpSellingPrice) {
		this.mrpSellingPrice = mrpSellingPrice;
	}
	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
