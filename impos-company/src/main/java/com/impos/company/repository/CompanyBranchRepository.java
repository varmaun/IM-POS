package com.impos.company.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.impos.company.domain.CompanyBranch;

/*
*@Author varma
*/
public interface CompanyBranchRepository
		extends JpaSpecificationExecutor<CompanyBranch>, PagingAndSortingRepository<CompanyBranch, Serializable> {

}
