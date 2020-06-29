package com.impos.catalogue.repository;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.impos.catalogue.domain.ProductSku;
@Repository
public interface ProductSkuRepository extends PagingAndSortingRepository<ProductSku, Serializable>, JpaSpecificationExecutor<ProductSku>{

}
