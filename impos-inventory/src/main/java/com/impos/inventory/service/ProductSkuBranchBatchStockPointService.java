package com.impos.inventory.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.avitcore.converters.NullAwareBeanUtilsBean;
import com.impos.inventory.domain.ProductSkuBranchBatchStockPoint;
import com.impos.inventory.repository.ProductSkuBranchBatchStockPointRepository;

/*
*@Author varma
*/
@Component
public class ProductSkuBranchBatchStockPointService implements IProductSkuBranchBatchStockPointService {
	@Autowired
	private NullAwareBeanUtilsBean nonNullBeanUtiles;

	@Autowired
	private ProductSkuBranchBatchStockPointRepository productSkuBranchBatchStockPointRepository;

	@Override
	@Transactional
	public ProductSkuBranchBatchStockPoint create(ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoint) {
		
		return productSkuBranchBatchStockPointRepository.save(productSkuBranchBatchStockPoint);
	}

	@Override
	public void deleteProductSkuBranchBatchStockPoint(String productSkuBranchBatchStockPointId) {

	}

	@Override
	public ProductSkuBranchBatchStockPoint getProductSkuBranchBatchStockPoint(
			String productSkuBranchBatchStockPointId) {
		Optional<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPointOpt = productSkuBranchBatchStockPointRepository
				.findById(productSkuBranchBatchStockPointId);
		ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoint = null;
		if (productSkuBranchBatchStockPointOpt.isPresent()) {
			productSkuBranchBatchStockPoint = productSkuBranchBatchStockPointOpt.get();
		} else {
			throw new EntityNotFoundException(productSkuBranchBatchStockPointId);
		}
		return productSkuBranchBatchStockPoint;
	}

	@Override
	public List<ProductSkuBranchBatchStockPoint> getAll() {
		List<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPoint = (List<ProductSkuBranchBatchStockPoint>) productSkuBranchBatchStockPointRepository
				.findAll();

		return productSkuBranchBatchStockPoint;
	}

	@Override
	@Transactional
	public ProductSkuBranchBatchStockPoint updateProductSkuBranchBatchStockPoint(
			ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoint) {
		ProductSkuBranchBatchStockPoint productSkuBranchBatchStockPoints = getProductSkuBranchBatchStockPoint(
				productSkuBranchBatchStockPoint.getId());
		try {
			nonNullBeanUtiles.copyProperties(productSkuBranchBatchStockPoints, productSkuBranchBatchStockPoint);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return productSkuBranchBatchStockPointRepository.save(productSkuBranchBatchStockPoints);
	}

	public ProductSkuBranchBatchStockPoint getProductSkuBranchBatchStockPointByContext(String batchId,
			String companyBranchId, String stockPointId, String uomId, String productSkuId) {

		Specification<ProductSkuBranchBatchStockPoint> productSkuBranchBatchStockPointSpecification = (root, query,
				cb) -> {
			ArrayList<Predicate> predicates = new ArrayList<>();
			if (batchId != null) {
				predicates.add(cb.equal(root.get("batchId"), batchId));
			}
			if (companyBranchId != null) {
				predicates.add(cb.equal(root.get("companyBranchId"), companyBranchId));
			}
			if (stockPointId != null) {
				predicates.add(cb.equal(root.get("stockPointId"), stockPointId));
			}
			if (productSkuId != null) {
				predicates.add(cb.equal(root.get("productSkuId"), productSkuId));
			}
			if (uomId != null) {
				predicates.add(cb.equal(root.get("uomId"), uomId));
			}
			return cb.and(predicates.toArray(new Predicate[] {}));
		};
		return productSkuBranchBatchStockPointRepository.findOne(productSkuBranchBatchStockPointSpecification)
				.orElse(null);

	}

}
