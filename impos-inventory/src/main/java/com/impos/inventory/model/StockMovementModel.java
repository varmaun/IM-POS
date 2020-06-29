package com.impos.inventory.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StockMovementModel extends AbstractModel {

	private String name;
	private String units;
	private String nonSellableUnits;
	private String quantity;
	private String productSkuId;
	private String companyBranchId;
	private String batchId;
	private String stockPointId;
	private String uomId;
	private String fromSku;
	private String toSku;
	private String fromSkuUom;
	private String toSkuUom;
	private String fromSkuQty;
	private String toSkuQty;
	private String fromStockPoint;
	private String toStockPoint;
	private String stockLogId;
	private String userApproved;
	private String approvalStatus;
	private String status;
	private String fromBatch;
	private String toBranch;
	private String fromBranch;
	private String expiryDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getFromSku() {
		return fromSku;
	}

	public void setFromSku(String fromSku) {
		this.fromSku = fromSku;
	}

	public String getToSku() {
		return toSku;
	}

	public void setToSku(String toSku) {
		this.toSku = toSku;
	}

	public String getFromSkuUom() {
		return fromSkuUom;
	}

	public void setFromSkuUom(String fromSkuUom) {
		this.fromSkuUom = fromSkuUom;
	}

	public String getToSkuUom() {
		return toSkuUom;
	}

	public void setToSkuUom(String toSkuUom) {
		this.toSkuUom = toSkuUom;
	}

	public String getFromSkuQty() {
		return fromSkuQty;
	}

	public void setFromSkuQty(String fromSkuQty) {
		this.fromSkuQty = fromSkuQty;
	}

	public String getToSkuQty() {
		return toSkuQty;
	}

	public void setToSkuQty(String toSkuQty) {
		this.toSkuQty = toSkuQty;
	}

	public String getFromStockPoint() {
		return fromStockPoint;
	}

	public void setFromStockPoint(String fromStockPoint) {
		this.fromStockPoint = fromStockPoint;
	}

	public String getToStockPoint() {
		return toStockPoint;
	}

	public void setToStockPoint(String toStockPoint) {
		this.toStockPoint = toStockPoint;
	}

	public String getStockLogId() {
		return stockLogId;
	}

	public void setStockLogId(String stockLogId) {
		this.stockLogId = stockLogId;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

}
