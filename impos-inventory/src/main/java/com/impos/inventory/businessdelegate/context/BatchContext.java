package com.impos.inventory.businessdelegate.context;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.avitcore.businessdelegate.context.IBusinessDelegateContext;
/*
*@Author varma
*/
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BatchContext implements IBusinessDelegateContext {

	private String batchId;
	private String all;
	
	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
