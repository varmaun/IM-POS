package com.impos.inventory.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.impos.inventory.domain.StockLogItems;
/*
*@Author varma
*/
public interface StockLogItemsRepository extends JpaSpecificationExecutor<StockLogItems>,PagingAndSortingRepository<StockLogItems, Serializable>{

}
