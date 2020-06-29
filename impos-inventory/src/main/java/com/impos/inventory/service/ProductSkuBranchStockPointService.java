package com.impos.inventory.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.inventory.domain.ProductSkuBranchStockPoint;
import com.impos.inventory.repository.ProductSkuBranchStockPointRepository;

/*
*@Author varma
*/
@Component
public class ProductSkuBranchStockPointService implements IProductSkuBranchStockPointService {
	@Autowired
	private NullAwareBeanUtilsBean nonNullBeanUtiles;

	@Autowired
	private ProductSkuBranchStockPointRepository productSkuBranchStockPointRepository;

	@Override
	@Transactional
	public ProductSkuBranchStockPoint create(ProductSkuBranchStockPoint productSkuBranchStockPoint) {
		return productSkuBranchStockPointRepository.save(productSkuBranchStockPoint);
	}

	@Override
	public void deleteProductSkuBranchStockPoint(String productSkuBranchStockPointId) {

	}

	@Override
	public ProductSkuBranchStockPoint getProductSkuBranchStockPoint(String productSkuBranchStockPointId) {

		return productSkuBranchStockPointRepository.findById(productSkuBranchStockPointId).orElse(null);
	}

	@Override
	public List<ProductSkuBranchStockPoint> getAll() {
		List<ProductSkuBranchStockPoint> productSkuBranchStockPoint = (List<ProductSkuBranchStockPoint>) productSkuBranchStockPointRepository
				.findAll();

		return productSkuBranchStockPoint;
	}

	@Override
	@Transactional
	public ProductSkuBranchStockPoint updateProductSkuBranchStockPoint(
			ProductSkuBranchStockPoint productSkuBranchStockPoint) {
		ProductSkuBranchStockPoint productSkuBranchStockPoints = getProductSkuBranchStockPoint(
				productSkuBranchStockPoint.getId());
		try {
			nonNullBeanUtiles.copyProperties(productSkuBranchStockPoints, productSkuBranchStockPoint);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return productSkuBranchStockPointRepository.save(productSkuBranchStockPoints);
	}

	public ProductSkuBranchStockPoint getProductSkuBranchStockPointByContext(String companyBranchId,
			String fromStockPoint, String uomId, String productSkuId) {
		Specification<ProductSkuBranchStockPoint> productSkuBranchStockPointSpecification = (root, query, cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			
			if (companyBranchId!=null) {
				predicates.add(cb.equal(root.get("companyBranchId"), companyBranchId));
			}
			if (fromStockPoint!=null) {
				predicates.add(cb.equal(root.get("stockPointId"), fromStockPoint));
			}
			if (productSkuId!=null) {
				predicates.add(cb.equal(root.get("productSkuId"), productSkuId));
			}
			if (uomId != null) {
				predicates.add(cb.equal(root.get("uomId"), uomId));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return productSkuBranchStockPointRepository.findOne(productSkuBranchStockPointSpecification).orElse(null);
	}

}
