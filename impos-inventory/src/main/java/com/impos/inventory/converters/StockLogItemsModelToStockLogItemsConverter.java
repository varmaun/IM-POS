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

import com.impos.inventory.domain.StockLogItems;
import com.impos.inventory.model.StockLogItemsModel;

/**
 * @author Jay
 *
 */
@Component("stockLogItemsModelToStockLogItemsConverter")
public class StockLogItemsModelToStockLogItemsConverter implements Converter<StockLogItemsModel, StockLogItems> {
    @Autowired
    private ObjectFactory<StockLogItems> stockLogItemsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public StockLogItems convert(final StockLogItemsModel source) {
        StockLogItems stockLogItems = stockLogItemsFactory.getObject();
        BeanUtils.copyProperties(source, stockLogItems);

        return stockLogItems;
    }

    @Autowired
    public void setStockLogItemsFactory(final ObjectFactory<StockLogItems> stockLogItemsFactory) {
        this.stockLogItemsFactory = stockLogItemsFactory;
    }

}
