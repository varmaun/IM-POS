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

import com.impos.inventory.domain.ProductSkuBranchBatchStockPoint;
import com.impos.inventory.model.ProductSkuBranchBatchStockPointModel;

/**
 * @author Jay
 *
 */
@Component("productSkuBranchBatchStockPointModelToProductSkuBranchBatchStockPointConverter")
public class ProductSkuBranchBatchStockPointModelToProductSkuBranchBatchStockPointConverter implements Converter<ProductSkuBranchBatchStockPointModel, ProductSkuBranchBatchStockPoint> {
    @Autowired
    private ObjectFactory<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPointFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ProductSkuBranchBatchStockPoint convert(final ProductSkuBranchBatchStockPointModel source) {
        ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoint = productSkuBranchBatchStockPointFactory.getObject();
        BeanUtils.copyProperties(source, productSkuBranchBatchStockPoint);

        return productSkuBranchBatchStockPoint;
    }

    @Autowired
    public void setProductSkuBranchBatchStockPointFactory(final ObjectFactory<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPointFactory) {
        this.productSkuBranchBatchStockPointFactory = productSkuBranchBatchStockPointFactory;
    }

}
