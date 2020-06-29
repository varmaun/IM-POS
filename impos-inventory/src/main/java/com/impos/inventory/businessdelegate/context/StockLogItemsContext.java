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
public class StockLogItemsContext implements IBusinessDelegateContext {

	private String stockLogItemsId;
	private String all;
	
	public String getStockLogItemsId() {
		return stockLogItemsId;
	}

	public void setStockLogItemsId(String stockLogItemsId) {
		this.stockLogItemsId = stockLogItemsId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
