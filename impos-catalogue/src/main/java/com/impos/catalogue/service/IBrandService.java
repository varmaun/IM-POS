package com.impos.catalogue.service;

import java.util.List;

import com.impos.catalogue.domain.Brand;
import com.impos.catalogue.businessdelegate.context.BrandContext;
public interface IBrandService {
	
	Brand create(Brand brand);

	void deleteBrand(String brandId);

	Brand getBrand(String brandId);

	List<Brand> getAll();

	Brand updateBrand(Brand brand);

	List<Brand> getAll(BrandContext context);

}
