package com.impos.user.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.impos.user.domain.Users;
/*
*@Author varma
*/
public interface UsersRepository extends JpaSpecificationExecutor<Users>,PagingAndSortingRepository<Users, Serializable>{

}
