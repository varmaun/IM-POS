package com.impos.inventory.service;

import java.util.List;

import com.impos.inventory.domain.StockLogs;
/*
*@Author varma
*/
public interface IStockLogsService {
	
	StockLogs create(StockLogs stockLogs);

	void deleteStockLogs(String stockLogsId);

	StockLogs getStockLogs(String stockLogsId);

	List<StockLogs> getAll();

	StockLogs updateStockLogs(StockLogs stockLogs);
}
