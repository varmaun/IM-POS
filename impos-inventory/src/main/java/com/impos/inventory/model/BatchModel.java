package com.impos.inventory.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.model.AbstractModel;

@Component("batchModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BatchModel extends AbstractModel {
	private String name, batchCode;
	private String parentBatchId;
	private Boolean isActive;
	private String companyId;

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

	public String getParentBatchId() {
		return parentBatchId;
	}

	public void setParentBatchId(String parentBatchId) {
		this.parentBatchId = parentBatchId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
