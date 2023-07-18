package com.companydetails.demo.dao;

import com.companydetails.demo.entities.Mapping;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MappingRepository extends JpaRepository<Mapping,Integer> {
    List<Mapping> findByIsDeletedFalse(Pageable p);
}
