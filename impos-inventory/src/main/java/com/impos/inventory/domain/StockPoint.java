package com.impos.inventory.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.impos.company.domain.Company;
import com.impos.company.domain.CompanyBranch;

@Table(name = "stock_point")
@Entity
@Component
@JsonInclude(value = Include.NON_NULL)
public class StockPoint extends AbstractDomain {
	@Column
	private String name, description;
	private CompanyBranch companyBranchId;
	private Company companyId;
	@Column
	private Boolean isActive;
	private Set<StockLogItems> stockLogItems;
	private Set<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPoints;
	private Set<ProductSkuBranchStockPoint> productSkuBranchStockPoints;

	public StockPoint() {
	}

	public StockPoint(String id, String name, String description, CompanyBranch companyBranchId, Company companyId,
			Boolean isActive, Set<StockLogItems> stockLogItems,
			Set<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPoints,
			Set<ProductSkuBranchStockPoint> productSkuBranchStockPoints) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.companyBranchId = companyBranchId;
		this.companyId = companyId;
		this.isActive = isActive;
		this.stockLogItems = stockLogItems;
		this.productSkuBranchBatchStockPoints = productSkuBranchBatchStockPoints;
		this.productSkuBranchStockPoints = productSkuBranchStockPoints;
	}

	public StockPoint(String id, String name, String description, CompanyBranch companyBranchId, Company companyId,
			Boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.companyBranchId = companyBranchId;
		this.companyId = companyId;
		this.isActive = isActive;
	}

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

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "company_branch_id")
	public CompanyBranch getCompanyBranchId() {
		return companyBranchId;
	}

	public void setCompanyBranchId(CompanyBranch companyBranchId) {
		this.companyBranchId = companyBranchId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "company_id")
	public Company getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stockPoint")
	public Set<StockLogItems> getStockLogItems() {
		return stockLogItems;
	}

	public void setStockLogItems(Set<StockLogItems> stockLogItems) {
		this.stockLogItems = stockLogItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stockPoint")
	public Set<ProductSkuBranchBatchStockPoint> getProductSkuBranchBatchStockPoints() {
		return productSkuBranchBatchStockPoints;
	}

	public void setProductSkuBranchBatchStockPoints(
			Set<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPoints) {
		this.productSkuBranchBatchStockPoints = productSkuBranchBatchStockPoints;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stockPoint")
	public Set<ProductSkuBranchStockPoint> getProductSkuBranchStockPoints() {
		return productSkuBranchStockPoints;
	}

	public void setProductSkuBranchStockPoints(Set<ProductSkuBranchStockPoint> productSkuBranchStockPoints) {
		this.productSkuBranchStockPoints = productSkuBranchStockPoints;
	}

}
