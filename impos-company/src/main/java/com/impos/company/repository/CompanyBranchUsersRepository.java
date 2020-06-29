package com.impos.company.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.impos.company.domain.CompanyBranchUsers;
/*
*@Author varma
*/
public interface CompanyBranchUsersRepository extends JpaSpecificationExecutor<CompanyBranchUsers>,PagingAndSortingRepository<CompanyBranchUsers, Serializable>{

}
