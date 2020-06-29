package com.impos.inventory.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.impos.inventory.domain.Batch;
/*
*@Author varma
*/
public interface BatchRepository extends JpaSpecificationExecutor<Batch>,PagingAndSortingRepository<Batch, Serializable>{

}
