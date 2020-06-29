package com.impos.settings.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.impos.settings.domain.UnitOfMeasurement;

@Repository
public interface UnitOfMeasurementRepository extends PagingAndSortingRepository<UnitOfMeasurement, Serializable>,JpaSpecificationExecutor<UnitOfMeasurement>{ 

}
