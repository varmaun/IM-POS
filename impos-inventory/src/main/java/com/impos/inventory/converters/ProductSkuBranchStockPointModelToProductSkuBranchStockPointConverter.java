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

import com.impos.inventory.domain.ProductSkuBranchStockPoint;
import com.impos.inventory.model.ProductSkuBranchStockPointModel;

/**
 * @author Jay
 *
 */
@Component("productSkuBranchStockPointModelToProductSkuBranchStockPointConverter")
public class ProductSkuBranchStockPointModelToProductSkuBranchStockPointConverter implements Converter<ProductSkuBranchStockPointModel, ProductSkuBranchStockPoint> {
    @Autowired
    private ObjectFactory<ProductSkuBranchStockPoint> productSkuBranchStockPointFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ProductSkuBranchStockPoint convert(final ProductSkuBranchStockPointModel source) {
        ProductSkuBranchStockPoint productSkuBranchStockPoint = productSkuBranchStockPointFactory.getObject();
        BeanUtils.copyProperties(source, productSkuBranchStockPoint);

        return productSkuBranchStockPoint;
    }

    @Autowired
    public void setProductSkuBranchStockPointFactory(final ObjectFactory<ProductSkuBranchStockPoint> productSkuBranchStockPointFactory) {
        this.productSkuBranchStockPointFactory = productSkuBranchStockPointFactory;
    }

}
