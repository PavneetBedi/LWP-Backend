package com.companydetails.demo.dao;

import com.companydetails.demo.entities.Training;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training,Integer> {
    List<Training> findByIsDeletedFalse(Pageable p);
}
