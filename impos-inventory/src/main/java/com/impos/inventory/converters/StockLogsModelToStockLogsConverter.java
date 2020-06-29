/**
 *
 */
package com.impos.inventory.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.inventory.domain.StockLogs;
import com.impos.inventory.model.StockLogsModel;

/**
 * @author Jay
 *
 */
@Component("stockLogsModelToStockLogsConverter")
public class StockLogsModelToStockLogsConverter implements Converter<StockLogsModel, StockLogs> {
    @Autowired
    private ObjectFactory<StockLogs> stockLogsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public StockLogs convert(final StockLogsModel source) {
        StockLogs stockLogs = stockLogsFactory.getObject();
        BeanUtils.copyProperties(source, stockLogs);

        return stockLogs;
    }

    @Autowired
    public void setStockLogsFactory(final ObjectFactory<StockLogs> stockLogsFactory) {
        this.stockLogsFactory = stockLogsFactory;
    }

}
