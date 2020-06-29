package com.impos.inventory.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.inventory.domain.StockPoint;
import com.impos.inventory.model.StockPointModel;

@Component("stockPointToStockPointModelConverter")
public class StockPointToStockPointModelConverter
        implements Converter<StockPoint, StockPointModel> {
    @Autowired
    private ObjectFactory<StockPointModel> stockPointModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public StockPointModel convert(final StockPoint source) {
        StockPointModel stockPointModel = stockPointModelFactory.getObject();
        BeanUtils.copyProperties(source, stockPointModel);

        return stockPointModel;
    }

    @Autowired
    public void setStockPointModelFactory(
            final ObjectFactory<StockPointModel> stockPointModelFactory) {
        this.stockPointModelFactory = stockPointModelFactory;
    }
}
