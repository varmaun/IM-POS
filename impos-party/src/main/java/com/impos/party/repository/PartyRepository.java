package com.impos.party.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.impos.party.domain.Party;
@Repository
public interface PartyRepository extends PagingAndSortingRepository<Party, Serializable>, JpaSpecificationExecutor<Party> {

}
