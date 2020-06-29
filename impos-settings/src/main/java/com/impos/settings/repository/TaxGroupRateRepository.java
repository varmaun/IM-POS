package com.impos.settings.repository;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.impos.settings.domain.TaxGroupRate;

@Repository
public interface TaxGroupRateRepository extends PagingAndSortingRepository<TaxGroupRate, Serializable>{

}
