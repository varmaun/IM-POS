package com.impos.inventory.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.inventory.domain.StockLogItems;
import com.impos.inventory.repository.StockLogItemsRepository;

/*
*@Author varma
*/
@Component
public class StockLogItemsService implements IStockLogItemsService {
	@Autowired
	private NullAwareBeanUtilsBean nonNullBeanUtiles;

	@Autowired
	private StockLogItemsRepository stockLogItemsRepository;

	@Override
	@Transactional
	public StockLogItems create(StockLogItems stockLogItems) {

		return stockLogItemsRepository.save(stockLogItems);
	}

	@Override
	public void deleteStockLogItems(String stockLogItemsId) {

	}

	@Override
	public StockLogItems getStockLogItems(String stockLogItemsId) {

		return stockLogItemsRepository.findById(stockLogItemsId).orElse(null);
	}

	@Override
	public List<StockLogItems> getAll() {
		List<StockLogItems> stockLogItems = (List<StockLogItems>) stockLogItemsRepository.findAll();

		return stockLogItems;
	}

	@Override
	public StockLogItems updateStockLogItems(StockLogItems stockLogItems) {
		StockLogItems stockLogItemss = getStockLogItems(stockLogItems.getId());
		try {
			nonNullBeanUtiles.copyProperties(stockLogItemss, stockLogItems);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return stockLogItemsRepository.save(stockLogItemss);
	}

}
