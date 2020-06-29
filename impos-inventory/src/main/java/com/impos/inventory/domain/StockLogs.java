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
import javax.persistence.Version;

import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import com.avitcore.domain.AbstractDomain;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.impos.company.domain.CompanyBranch;

@Table(name = "stock_logs")
@Entity
@Component
@JsonInclude(value = Include.NON_NULL)
public class StockLogs extends AbstractDomain implements Serializable {

	private String userApproved;
	private String approvalStatus;
	private String refDocPath;
	private String refNo;
	private String refDesc;
	private String status;
	private String purchaseOrderId;
	private String invoiceId;
	private Batch fromBatch;
	private CompanyBranch toBranch;
	private CompanyBranch fromBranch;
	private Set<StockLogItems> stockLogItems;
	@Version
	private Long version;
	public StockLogs() {

	}

	public StockLogs(Batch fromBatch, String userApproved, String approvalStatus, String refDocPath, String refNo,
			String refDesc, String status, Long version, String purchaseOrderId, String invoiceId,
			CompanyBranch toBranch, CompanyBranch fromBranch, Set<StockLogItems> stockLogItems) {
		super();
		this.fromBatch = fromBatch;
		this.userApproved = userApproved;
		this.approvalStatus = approvalStatus;
		this.refDocPath = refDocPath;
		this.refNo = refNo;
		this.refDesc = refDesc;
		this.status = status;
		this.version = version;
		this.purchaseOrderId = purchaseOrderId;
		this.invoiceId = invoiceId;
		this.toBranch = toBranch;
		this.fromBranch = fromBranch;
		this.stockLogItems = stockLogItems;
	}

	public StockLogs(String id, Batch fromBatch, String userApproved, String approvalStatus, String refDocPath,
			String refNo, String refDesc, String status, Long version, String purchaseOrderId, String invoiceId,
			String userCreated, String userModified, CompanyBranch toBranch, CompanyBranch fromBranch,
			LocalDateTime createdDate, LocalDateTime modifiedDate, Set<StockLogItems> stockLogItems) {
		this.id = id;
		this.fromBatch = fromBatch;
		this.userApproved = userApproved;
		this.approvalStatus = approvalStatus;
		this.refDocPath = refDocPath;
		this.refNo = refNo;
		this.refDesc = refDesc;
		this.status = status;
		this.version = version;
		this.purchaseOrderId = purchaseOrderId;
		this.invoiceId = invoiceId;
		this.toBranch = toBranch;
		this.fromBranch = fromBranch;
		this.stockLogItems = stockLogItems;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.userCreated = userCreated;
		this.userModified = userModified;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "batch_id")
	public Batch getFromBatch() {
		return fromBatch;
	}

	public void setFromBatch(Batch fromBatch) {
		this.fromBatch = fromBatch;
	}

	@Column
	public String getUserApproved() {
		return userApproved;
	}

	public void setUserApproved(String userApproved) {
		this.userApproved = userApproved;
	}

	@Column
	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	@Column
	public String getRefDocPath() {
		return refDocPath;
	}

	public void setRefDocPath(String refDocPath) {
		this.refDocPath = refDocPath;
	}

	@Column
	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	@Column
	public String getRefDesc() {
		return refDesc;
	}

	public void setRefDesc(String refDesc) {
		this.refDesc = refDesc;
	}

	@Column
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "company_branch_id")
	public CompanyBranch getToBranch() {
		return toBranch;
	}

	public void setToBranch(CompanyBranch toBranch) {
		this.toBranch = toBranch;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "company_branch_id")
	public CompanyBranch getFromBranch() {
		return fromBranch;
	}

	public void setFromBranch(CompanyBranch fromBranch) {
		this.fromBranch = fromBranch;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stockLogs")
	public Set<StockLogItems> getStockLogItems() {
		return stockLogItems;
	}

	public void setStockLogItems(Set<StockLogItems> stockLogItems) {
		this.stockLogItems = stockLogItems;
	}

}
