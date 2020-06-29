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

import com.impos.company.domain.Company;
import com.impos.company.domain.CompanyBranch;
import com.impos.inventory.domain.StockPoint;
import com.impos.inventory.model.StockPointModel;

/**
 * @author Jay
 *
 */
@Component("stockPointModelToStockPointConverter")
public class StockPointModelToStockPointConverter implements Converter<StockPointModel, StockPoint> {
    @Autowired
    private ObjectFactory<StockPoint> stockPointFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public StockPoint convert(final StockPointModel source) {
        StockPoint stockPoint = stockPointFactory.getObject();
        BeanUtils.copyProperties(source, stockPoint);
        if(source.getCompanyBranchId()!=null) {
        	CompanyBranch cb = new CompanyBranch();
        	cb.setId(source.getCompanyBranchId());
        	stockPoint.setCompanyBranchId(cb);
        }
        if(source.getCompanyId()!=null) {
        	Company com = new Company();
        	com.setId(source.getCompanyId());
        	stockPoint.setCompanyId(com);
        }
        return stockPoint;
    }

    @Autowired
    public void setStockPointFactory(final ObjectFactory<StockPoint> stockPointFactory) {
        this.stockPointFactory = stockPointFactory;
    }

}
