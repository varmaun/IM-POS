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

import com.impos.inventory.domain.Batch;
import com.impos.inventory.model.BatchModel;

/**
 * @author Jay
 *
 */
@Component("batchModelToBatchConverter")
public class BatchModelToBatchConverter implements Converter<BatchModel, Batch> {
    @Autowired
    private ObjectFactory<Batch> batchFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Batch convert(final BatchModel source) {
        Batch batch = batchFactory.getObject();
        BeanUtils.copyProperties(source, batch);

        return batch;
    }

    @Autowired
    public void setBatchFactory(final ObjectFactory<Batch> batchFactory) {
        this.batchFactory = batchFactory;
    }

}
