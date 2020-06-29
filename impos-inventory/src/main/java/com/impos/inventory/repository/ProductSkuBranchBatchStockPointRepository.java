package com.impos.inventory.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.impos.inventory.domain.ProductSkuBranchBatchStockPoint;
/*
*@Author varma
*/
public interface ProductSkuBranchBatchStockPointRepository extends JpaSpecificationExecutor<ProductSkuBranchBatchStockPoint>,PagingAndSortingRepository<ProductSkuBranchBatchStockPoint, Serializable>{

}
