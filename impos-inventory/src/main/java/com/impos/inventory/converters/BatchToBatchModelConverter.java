package com.impos.inventory.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.inventory.domain.Batch;
import com.impos.inventory.model.BatchModel;

@Component("batchToBatchModelConverter")
public class BatchToBatchModelConverter
        implements Converter<Batch, BatchModel> {
    @Autowired
    private ObjectFactory<BatchModel> batchModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public BatchModel convert(final Batch source) {
        BatchModel batchModel = batchModelFactory.getObject();
        BeanUtils.copyProperties(source, batchModel);
        batchModel.setCreatedDate(source.getCreatedDate().toString("dd-MM-YYYY HH:MM:SS"));
        return batchModel;
    } 

    @Autowired
    public void setBatchModelFactory(
            final ObjectFactory<BatchModel> batchModelFactory) {
        this.batchModelFactory = batchModelFactory;
    }
}
