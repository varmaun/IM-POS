package com.impos.inventory.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.impos.inventory.domain.StockLogs;
/*
*@Author varma
*/
public interface StockLogsRepository extends JpaSpecificationExecutor<StockLogs>,PagingAndSortingRepository<StockLogs, Serializable>{

}
