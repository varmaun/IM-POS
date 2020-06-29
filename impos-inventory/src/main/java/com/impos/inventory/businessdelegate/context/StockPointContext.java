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
public class StockPointContext implements IBusinessDelegateContext {

	private String stockPointId;
	private String all;
	
	public String getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(String stockPointId) {
		this.stockPointId = stockPointId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
