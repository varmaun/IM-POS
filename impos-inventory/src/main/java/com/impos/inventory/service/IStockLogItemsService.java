package com.impos.inventory.service;

import java.util.List;

import com.impos.inventory.domain.StockLogItems;
/*
*@Author varma
*/
public interface IStockLogItemsService {
	
	StockLogItems create(StockLogItems stockLogItems);

	void deleteStockLogItems(String stockLogItemsId);

	StockLogItems getStockLogItems(String stockLogItemsId);

	List<StockLogItems> getAll();

	StockLogItems updateStockLogItems(StockLogItems stockLogItems);
}
