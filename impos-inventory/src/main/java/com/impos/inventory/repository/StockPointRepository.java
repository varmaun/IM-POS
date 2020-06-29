package com.impos.inventory.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.impos.inventory.domain.StockPoint;
/*
*@Author varma
*/
public interface StockPointRepository extends JpaSpecificationExecutor<StockPoint>,PagingAndSortingRepository<StockPoint, Serializable>{

}
