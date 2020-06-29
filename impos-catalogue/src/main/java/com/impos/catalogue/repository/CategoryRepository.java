package com.impos.catalogue.repository;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.impos.catalogue.domain.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Serializable>, JpaSpecificationExecutor<Category>{

}
