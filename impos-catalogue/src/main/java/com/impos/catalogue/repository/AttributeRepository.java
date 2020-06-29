package com.impos.catalogue.repository;

import java.io.Serializable;
import com.impos.catalogue.domain.Attribute;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
@Repository
public interface AttributeRepository extends PagingAndSortingRepository<Attribute, Serializable>, JpaSpecificationExecutor<Attribute>{

}
