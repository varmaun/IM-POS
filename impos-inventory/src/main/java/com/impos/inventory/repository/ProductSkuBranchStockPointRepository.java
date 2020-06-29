package com.impos.inventory.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.impos.inventory.domain.ProductSkuBranchStockPoint;
/*
*@Author varma
*/
public interface ProductSkuBranchStockPointRepository extends JpaSpecificationExecutor<ProductSkuBranchStockPoint>,PagingAndSortingRepository<ProductSkuBranchStockPoint, Serializable>{

}
