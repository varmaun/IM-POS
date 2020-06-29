package com.impos.inventory.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impos.inventory.domain.ProductSkuBranchStockPoint;
import com.impos.inventory.model.ProductSkuBranchStockPointModel;

@Component("productSkuBranchStockPointToProductSkuBranchStockPointModelConverter")
public class ProductSkuBranchStockPointToProductSkuBranchStockPointModelConverter
        implements Converter<ProductSkuBranchStockPoint, ProductSkuBranchStockPointModel> {
    @Autowired
    private ObjectFactory<ProductSkuBranchStockPointModel> productSkuBranchStockPointModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ProductSkuBranchStockPointModel convert(final ProductSkuBranchStockPoint source) {
        ProductSkuBranchStockPointModel productSkuBranchStockPointModel = productSkuBranchStockPointModelFactory.getObject();
        BeanUtils.copyProperties(source, productSkuBranchStockPointModel);

        return productSkuBranchStockPointModel;
    }

    @Autowired
    public void setProductSkuBranchStockPointModelFactory(
            final ObjectFactory<ProductSkuBranchStockPointModel> productSkuBranchStockPointModelFactory) {
        this.productSkuBranchStockPointModelFactory = productSkuBranchStockPointModelFactory;
    }
}
