package com.impos.inventory.model;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;
import com.impos.inventory.domain.StockLogItems;

@Component("stockLogsModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StockLogsModel extends AbstractModel {

	private String userApproved;
	private String approvalStatus;
	private String refDocPath;
	private String refNo;
	private String refDesc;
	private String status;
	private String purchaseOrderId;
	private String invoiceId;
	private String fromBatch;
	private String toBranch;
	private String fromBranch;
	private List<StockLogItems> stockLogItems;

	public String getUserApproved() {
		return userApproved;
	}

	public void setUserApproved(String userApproved) {
		this.userApproved = userApproved;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getRefDocPath() {
		return refDocPath;
	}

	public void setRefDocPath(String refDocPath) {
		this.refDocPath = refDocPath;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getRefDesc() {
		return refDesc;
	}

	public void setRefDesc(String refDesc) {
		this.refDesc = refDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getFromBatch() {
		return fromBatch;
	}

	public void setFromBatch(String fromBatch) {
		this.fromBatch = fromBatch;
	}

	public String getToBranch() {
		return toBranch;
	}

	public void setToBranch(String toBranch) {
		this.toBranch = toBranch;
	}

	public String getFromBranch() {
		return fromBranch;
	}

	public void setFromBranch(String fromBranch) {
		this.fromBranch = fromBranch;
	}

	public List<StockLogItems> getStockLogItems() {
		return stockLogItems;
	}

	public void setStockLogItems(List<StockLogItems> stockLogItems) {
		this.stockLogItems = stockLogItems;
	}

}
