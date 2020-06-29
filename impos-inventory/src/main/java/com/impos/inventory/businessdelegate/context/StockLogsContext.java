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
public class StockLogsContext implements IBusinessDelegateContext {

	private String stockLogsId;
	private String all;
	
	public String getStockLogsId() {
		return stockLogsId;
	}

	public void setStockLogsId(String stockLogsId) {
		this.stockLogsId = stockLogsId;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

}
