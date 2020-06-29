package com.impos.inventory.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.inventory.domain.StockLogItems;
import com.impos.inventory.model.StockLogItemsModel;

@Component("stockLogItemsToStockLogItemsModelConverter")
public class StockLogItemsToStockLogItemsModelConverter
        implements Converter<StockLogItems, StockLogItemsModel> {
    @Autowired
    private ObjectFactory<StockLogItemsModel> stockLogItemsModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public StockLogItemsModel convert(final StockLogItems source) {
        StockLogItemsModel stockLogItemsModel = stockLogItemsModelFactory.getObject();
        BeanUtils.copyProperties(source, stockLogItemsModel);

        return stockLogItemsModel;
    }

    @Autowired
    public void setStockLogItemsModelFactory(
            final ObjectFactory<StockLogItemsModel> stockLogItemsModelFactory) {
        this.stockLogItemsModelFactory = stockLogItemsModelFactory;
    }
}
