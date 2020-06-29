package com.impos.settings.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.impos.settings.domain.TaxRate;

@Repository
public interface TaxRateRepository extends PagingAndSortingRepository<TaxRate, Serializable>,JpaSpecificationExecutor<TaxRate>{

}
