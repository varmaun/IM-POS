package com.impos.catalogue.businessdelegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.avitcore.businessdelegate.IBusinessDelegate;
import com.avitcore.businessdelegate.model.IKeyBuilder;
import com.impos.catalogue.businessdelegate.context.ProductPriceAuditContext;
import com.impos.catalogue.model.ProductPriceAuditModel;
import com.impos.catalogue.service.IProductPriceAuditService;
import com.impos.catalogue.domain.ProductPriceAudit;

@Service
public class ProductPriceAuditBusinessDelegate 
implements IBusinessDelegate<ProductPriceAuditModel,ProductPriceAuditContext, IKeyBuilder<String>, String>{
	
	@Autowired
	private IProductPriceAuditService productPriceAuditService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public ProductPriceAuditModel create(ProductPriceAuditModel model) {
		ProductPriceAudit productPriceAudit = new ProductPriceAudit();
		converter(model, productPriceAudit);
		productPriceAuditService.create(productPriceAudit);
		converter(productPriceAudit, model);
		return model;
	}

	@Override
	public void delete(IKeyBuilder<String> keyBuilder, ProductPriceAuditContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductPriceAuditModel edit(IKeyBuilder<String> keyBuilder, ProductPriceAuditModel model) {
		if(model!=null && model.getId()!=null) {
//			 existingDepartment = departmentService.getDepartment(model.getId());
			ProductPriceAudit productPriceAudit = new ProductPriceAudit();
			converter(model,productPriceAudit);
			productPriceAuditService.updateProductPriceAudit(productPriceAudit);
			converter(productPriceAudit,model);
		}
		return model;
	}

	@Override
	public ProductPriceAuditModel edit(IKeyBuilder<String> keyBuilder, ProductPriceAuditModel model,
			ProductPriceAuditContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductPriceAuditModel getByKey(IKeyBuilder<String> keyBuilder, ProductPriceAuditContext context) {
		ProductPriceAudit productPriceAudit = productPriceAuditService.getProductPriceAudit(keyBuilder.build().toString());
		ProductPriceAuditModel model = new ProductPriceAuditModel();
		converter(productPriceAudit,model);
		return model;
	}

	@Override
	public Collection<ProductPriceAuditModel> getCollection(ProductPriceAuditContext context) {
		List<ProductPriceAuditModel> models = new ArrayList<ProductPriceAuditModel>();
		for(ProductPriceAudit productPriceAudit:productPriceAuditService.getAll(context)) {
			ProductPriceAuditModel model = new ProductPriceAuditModel();
			converter(productPriceAudit,model);
			models.add(model);
		}
		return models;
	}
	
	private void converter(ProductPriceAudit source,ProductPriceAuditModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(ProductPriceAuditModel source, ProductPriceAudit target) {

		BeanUtils.copyProperties(source, target);
	}

}
