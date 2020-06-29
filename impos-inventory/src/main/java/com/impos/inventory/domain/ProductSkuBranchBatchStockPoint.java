package com.impos.inventory.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.impos.catalogue.domain.ProductSku;
import com.impos.company.domain.CompanyBranch;
import com.impos.settings.domain.UnitOfMeasurement;

@Table(name = "product_sku_branch_batch_stock_point")
@Entity
@Component
@JsonInclude(value = Include.NON_NULL)
public class ProductSkuBranchBatchStockPoint extends AbstractDomain implements Serializable {

	private Double units;
	private Double nonSellableUnits;
	private Double quantity;
	private ProductSku productSkuId;
	private CompanyBranch compnayBranchId;
	private Batch batchId;
	private StockPoint stockPointId;
	private UnitOfMeasurement uomId;
	private LocalDate expiryDate;

	public ProductSkuBranchBatchStockPoint() {

	}

	public ProductSkuBranchBatchStockPoint(Double units, Double nonSellableUnits, Double quantity,
			ProductSku productSkuId, CompanyBranch compnayBranchId, Batch batchId, StockPoint stockPointId,
			UnitOfMeasurement uomId, LocalDate expiryDate) {
		this.units = units;
		this.nonSellableUnits = nonSellableUnits;
		this.quantity = quantity;
		this.productSkuId = productSkuId;
		this.compnayBranchId = compnayBranchId;
		this.batchId = batchId;
		this.stockPointId = stockPointId;
		this.uomId = uomId;
		this.expiryDate = expiryDate;
	}

	@Column
	public Double getUnits() {
		return units;
	}

	public void setUnits(Double units) {
		this.units = units;
	}

	@Column
	public Double getNonSellableUnits() {
		return nonSellableUnits;
	}

	public void setNonSellableUnits(Double nonSellableUnits) {
		this.nonSellableUnits = nonSellableUnits;
	}

	@Column
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "product_sku_id")
	public ProductSku getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(ProductSku productSkuId) {
		this.productSkuId = productSkuId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "company_branch_id")
	public CompanyBranch getCompnayBranchId() {
		return compnayBranchId;
	}

	public void setCompnayBranchId(CompanyBranch compnayBranchId) {
		this.compnayBranchId = compnayBranchId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "batch_id")
	public Batch getBatchId() {
		return batchId;
	}

	public void setBatchId(Batch batchId) {
		this.batchId = batchId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "stock_point_id")
	public StockPoint getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(StockPoint stockPointId) {
		this.stockPointId = stockPointId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "uom_id")
	public UnitOfMeasurement getUomId() {
		return uomId;
	}

	public void setUomId(UnitOfMeasurement uomId) {
		this.uomId = uomId;
	}

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(name = "expiry_date", nullable = false, length = 19, insertable = false, updatable = true)
	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

}
