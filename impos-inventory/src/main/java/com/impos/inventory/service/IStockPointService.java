package com.impos.inventory.service;

import java.util.List;

import com.impos.inventory.domain.StockPoint;
/*
*@Author varma
*/
public interface IStockPointService {
	
	StockPoint create(StockPoint stockPoint);

	void deleteStockPoint(String stockPointId);

	StockPoint getStockPoint(String stockPointId);

	List<StockPoint> getAll();

	StockPoint updateStockPoint(StockPoint stockPoint);
}
