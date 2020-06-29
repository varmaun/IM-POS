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
import com.impos.catalogue.businessdelegate.context.BrandContext;
import com.impos.catalogue.model.BrandModel;
import com.impos.catalogue.service.IBrandService;
import com.impos.catalogue.domain.Brand;
@Service
public class BrandBusinessDelegate implements IBusinessDelegate<BrandModel,BrandContext, IKeyBuilder<String>, String>{

	@Autowired
	private IBrandService brandService;
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public BrandModel create(BrandModel model) {
		Brand brand = new Brand();
		converter(model, brand);
		brandService.create(brand);
		converter(brand, model);
		return model;
	}
	@Override
	public void delete(IKeyBuilder<String> keyBuilder, BrandContext context) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public BrandModel edit(IKeyBuilder<String> keyBuilder, BrandModel model) {
		if(model!=null && model.getId()!=null) {
			Brand brand = new Brand();
			converter(model,brand);
			brandService.updateBrand(brand);
			converter(brand,model);
		}
		return model;
	}
	@Override
	public BrandModel edit(IKeyBuilder<String> keyBuilder, BrandModel model, BrandContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BrandModel getByKey(IKeyBuilder<String> keyBuilder, BrandContext context) {
		Brand brand = brandService.getBrand(keyBuilder.build().toString());
		BrandModel model = new BrandModel();
		converter(brand,model);
		return model;
	}
	@Override
	public Collection<BrandModel> getCollection(BrandContext context) {
		List<BrandModel> models = new ArrayList<BrandModel>();
		for(Brand brand:brandService.getAll(context)) {
			BrandModel model = new BrandModel();
			converter(brand,model);
			models.add(model);
		}
		return models;
	}
	private void converter(Brand source,BrandModel target) {

		BeanUtils.copyProperties(source, target);
	}

	private void converter(BrandModel source, Brand target) {

		BeanUtils.copyProperties(source, target);
	}
}
