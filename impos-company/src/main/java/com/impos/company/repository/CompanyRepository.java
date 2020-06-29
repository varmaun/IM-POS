package com.impos.company.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.impos.company.domain.Company;

@Repository
public interface CompanyRepository
		extends PagingAndSortingRepository<Company, Serializable>, JpaSpecificationExecutor<Company> {

}
