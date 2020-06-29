package com.impos.catalogue.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.catalogue.businessdelegate.context.BrandContext;
import com.impos.catalogue.domain.Brand;
import com.impos.catalogue.repository.BrandRepository;

/**
 * @author Jay
 *
 */
@Component
public class BrandService implements IBrandService{

	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private NullAwareBeanUtilsBean nullAwareBeanUtils;
	
	@Override
	public Brand create(Brand brand) {
		brandRepository.save(brand);
		return brand;
	}
	@Override
	public void deleteBrand(String brandId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Brand getBrand(String brandId) {
		// TODO Auto-generated method stub
		return brandRepository.findById(brandId).orElse(null);
	}
	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Brand updateBrand(Brand brand) {
		if(brand!=null) {
			Brand brandm = getBrand(brand.getId());
			try {
				nullAwareBeanUtils.copyProperties(brandm, brand);
				brandRepository.save(brandm);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	return brand;
	}
	@Override
	public List<Brand> getAll(BrandContext context) {
		Specification<Brand> brandSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("companyId") != null) {
				predicates.add(cb.equal(root.get("companyId"), context.getContextParams().get("companyId")));
			}
			if (!context.getContextParams().isEmpty() && context.getContextParams().get("isActive") != null) {
				predicates.add(cb.equal(root.get("isActive"), context.getContextParams().get("status")));
			}
			
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return brandRepository.findAll(brandSpecification);
	}
}
