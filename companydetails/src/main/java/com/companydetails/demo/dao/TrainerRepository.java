package com.companydetails.demo.dao;

import com.companydetails.demo.entities.Trainer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
    List<Trainer> findByIsDeletedFalse(Pageable p);
}
