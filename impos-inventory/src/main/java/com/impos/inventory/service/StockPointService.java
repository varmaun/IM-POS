package com.impos.inventory.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.inventory.domain.StockPoint;
import com.impos.inventory.repository.StockPointRepository;
/*
*@Author varma
*/
@Component
public class StockPointService implements IStockPointService{
	@Autowired
	private NullAwareBeanUtilsBean nonNullBeanUtiles;

	@Autowired
	private StockPointRepository stockPointRepository;
	@Override
	public StockPoint create(StockPoint stockPoint) {
		stockPoint.setIsActive(true);
		return stockPointRepository.save(stockPoint);
	}

	@Override
	public void deleteStockPoint(String stockPointId) {
		
		
	}

	@Override
	public StockPoint getStockPoint(String stockPointId) {
		
		 return stockPointRepository.findById(stockPointId).orElse(null);
	}

	@Override
	public List<StockPoint> getAll() {
	List<StockPoint> stockPoint= (List<StockPoint>)stockPointRepository.findAll();

		return stockPoint;
	}

	@Override
	public StockPoint updateStockPoint(StockPoint stockPoint) {
StockPoint stockPoints = getStockPoint(stockPoint
				.getId());
		try {
			nonNullBeanUtiles.copyProperties(stockPoints, stockPoint);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

	return stockPointRepository.save(stockPoints);
	}

}
