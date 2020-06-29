package com.impos.inventory.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.inventory.domain.ProductSkuBranchBatchStockPoint;
import com.impos.inventory.model.ProductSkuBranchBatchStockPointModel;

@Component("productSkuBranchBatchStockPointToProductSkuBranchBatchStockPointModelConverter")
public class ProductSkuBranchBatchStockPointToProductSkuBranchBatchStockPointModelConverter
        implements Converter<ProductSkuBranchBatchStockPoint, ProductSkuBranchBatchStockPointModel> {
    @Autowired
    private ObjectFactory<ProductSkuBranchBatchStockPointModel> productSkuBranchBatchStockPointModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ProductSkuBranchBatchStockPointModel convert(final ProductSkuBranchBatchStockPoint source) {
        ProductSkuBranchBatchStockPointModel productSkuBranchBatchStockPointModel = productSkuBranchBatchStockPointModelFactory.getObject();
        BeanUtils.copyProperties(source, productSkuBranchBatchStockPointModel);

        return productSkuBranchBatchStockPointModel;
    }

    @Autowired
    public void setProductSkuBranchBatchStockPointModelFactory(
            final ObjectFactory<ProductSkuBranchBatchStockPointModel> productSkuBranchBatchStockPointModelFactory) {
        this.productSkuBranchBatchStockPointModelFactory = productSkuBranchBatchStockPointModelFactory;
    }
}
