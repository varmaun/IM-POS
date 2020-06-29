package com.impos.inventory.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.avitcore.exception.RecordNotFoundException;
import com.impos.inventory.domain.StockLogItems;
import com.impos.inventory.domain.StockLogs;
import com.impos.inventory.repository.StockLogsRepository;

/*
*@Author varma
*/
@Component
public class StockLogsService implements IStockLogsService {
	@Autowired
	private NullAwareBeanUtilsBean nonNullBeanUtiles;
	@Autowired
	private StockLogItemsService stockLogItemsService;
	@Autowired
	private StockLogsRepository stockLogsRepository;

	@Override
	@Transactional
	public StockLogs create(StockLogs stockLogs) {
		StockLogs stockLog = stockLogsRepository.save(stockLogs);
		if (stockLog != null && !stockLog.getId().isEmpty()
				&& CollectionUtils.isNotEmpty(stockLogs.getStockLogItems())) {
			StockLogItems stockLogItm = null;
			for (StockLogItems stockLogItems : stockLogs.getStockLogItems()) {
				stockLogItm = stockLogItems;
				stockLogItm.setStockLogId(stockLog);
				stockLogItm = stockLogItemsService.create(stockLogItm);
			}
			if(stockLogItm==null) {
				throw new RecordNotFoundException("Stock Log Items Not Created");
			}
		}else {
			throw new RecordNotFoundException("Stock Logs Not Created");
		}
		return stockLog;
	}

	@Override
	public void deleteStockLogs(String stockLogsId) {

	}

	@Override
	public StockLogs getStockLogs(String stockLogsId) {

		return stockLogsRepository.findById(stockLogsId).orElse(null);
	}

	@Override
	public List<StockLogs> getAll() {
		List<StockLogs> stockLogs = (List<StockLogs>) stockLogsRepository.findAll();

		return stockLogs;
	}

	@Override
	public StockLogs updateStockLogs(StockLogs stockLogs) {
		StockLogs stockLogss = getStockLogs(stockLogs.getId());
		try {
			nonNullBeanUtiles.copyProperties(stockLogss, stockLogs);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return stockLogsRepository.save(stockLogss);
	}

}
