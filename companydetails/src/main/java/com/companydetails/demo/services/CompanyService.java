package com.companydetails.demo.services;

import com.companydetails.demo.dao.CompanyRepository;
import com.companydetails.demo.entities.Company;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies(Integer pageNumber,Integer pageSize){
          Pageable p= PageRequest.of(pageNumber,pageSize);
          List<Company> pagePost=  this.companyRepository.findByIsDeletedFalse(p);
          return pagePost;
    }
    public Company getfindById(int id) {
        Optional<Company> optional = companyRepository.findById(id);
        if (((Optional<?>) optional).isPresent() && !optional.get().isDeleted()) {
            return optional.get();
        }
        throw new EntityNotFoundException("MyEntity with id " + id + " not found or has been deleted.");
    }

    public Company save(Company myEntity) {
        return companyRepository.save(myEntity);
    }

    public void deleteById(int id) {
        Company myEntity = getfindById(id);
        myEntity.setDeleted(true);
        companyRepository.save(myEntity);
    }

    public long getRowCount() {
        return companyRepository.count();
    }
}

