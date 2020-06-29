package com.impos.catalogue.repository;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.impos.catalogue.domain.Product;
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Serializable>, JpaSpecificationExecutor<Product>{

}
