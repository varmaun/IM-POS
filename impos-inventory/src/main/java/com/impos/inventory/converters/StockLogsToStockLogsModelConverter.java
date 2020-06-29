package com.impos.inventory.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.inventory.domain.StockLogs;
import com.impos.inventory.model.StockLogsModel;

@Component("stockLogsToStockLogsModelConverter")
public class StockLogsToStockLogsModelConverter
        implements Converter<StockLogs, StockLogsModel> {
    @Autowired
    private ObjectFactory<StockLogsModel> stockLogsModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public StockLogsModel convert(final StockLogs source) {
        StockLogsModel stockLogsModel = stockLogsModelFactory.getObject();
        BeanUtils.copyProperties(source, stockLogsModel);

        return stockLogsModel;
    }

    @Autowired
    public void setStockLogsModelFactory(
            final ObjectFactory<StockLogsModel> stockLogsModelFactory) {
        this.stockLogsModelFactory = stockLogsModelFactory;
    }
}
