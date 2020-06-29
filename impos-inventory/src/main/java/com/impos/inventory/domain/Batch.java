package com.impos.inventory.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Table(name = "batch")
@Entity
@Component
@JsonInclude(value = Include.NON_NULL)
public class Batch extends AbstractDomain implements Serializable {
	@Column
	private String name, batchCode;
	private Batch parentBatchId;
	@Column
	private Boolean isActive;
	private Set<StockLogs> stockLogs;
	private Set<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPoints;

	public Batch() {
	}

	public Batch(String id, String name, String batchCode, String userCreated, String userModified, Batch parentBatchId,
			Boolean isActive, LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.id = id;
		this.batchCode = batchCode;
		this.userCreated = userCreated;
		this.userModified = userModified;
		this.parentBatchId = parentBatchId;
		this.isActive = isActive;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;

	}

	public Batch(String id, String name, String batchCode, String userCreated, String userModified, Batch parentBatchId,
			Boolean isActive, LocalDateTime createdDate, LocalDateTime modifiedDate, Set<StockLogs> stockLogs,
			Set<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPoints) {
		this.id = id;
		this.batchCode = batchCode;
		this.userCreated = userCreated;
		this.userModified = userModified;
		this.parentBatchId = parentBatchId;
		this.isActive = isActive;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.stockLogs = stockLogs;
		this.productSkuBranchBatchStockPoints = productSkuBranchBatchStockPoints;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "parent_batch_id")
	public Batch getParentBatchId() {
		return parentBatchId;
	}

	public void setParentBatchId(Batch parentBatchId) {
		this.parentBatchId = parentBatchId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "batch")
	public Set<StockLogs> getStockLogs() {
		return stockLogs;
	}

	public void setStockLogs(Set<StockLogs> stockLogs) {
		this.stockLogs = stockLogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "batch")
	public Set<ProductSkuBranchBatchStockPoint> getProductSkuBranchBatchStockPoints() {
		return productSkuBranchBatchStockPoints;
	}

	public void setProductSkuBranchBatchStockPoints(
			Set<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPoints) {
		this.productSkuBranchBatchStockPoints = productSkuBranchBatchStockPoints;
	}

}
