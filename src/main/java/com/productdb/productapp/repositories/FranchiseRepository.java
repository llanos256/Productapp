package com.productdb.productapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productdb.productapp.models.Franchise;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Long>{

}
