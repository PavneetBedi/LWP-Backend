package com.companydetails.demo.dao;

import com.companydetails.demo.entities.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    List<Company> findByIsDeletedFalse(Pageable p);

}
