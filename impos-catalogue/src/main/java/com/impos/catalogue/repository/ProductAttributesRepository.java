package com.impos.catalogue.repository;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.impos.catalogue.domain.ProductAttributes;
public interface ProductAttributesRepository extends PagingAndSortingRepository<ProductAttributes, Serializable>, JpaSpecificationExecutor<ProductAttributes>{

}
