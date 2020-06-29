package com.impos.settings.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.impos.settings.domain.CodeGen;

public interface CodeGenRepository extends PagingAndSortingRepository<CodeGen, Serializable>, JpaSpecificationExecutor<CodeGen> {

	CodeGen findByCompanyId(String companyId);
	

}
