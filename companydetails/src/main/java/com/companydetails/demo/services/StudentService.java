package com.companydetails.demo.services;

import com.companydetails.demo.dao.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.companydetails.demo.entities.Student;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    @Autowired
    private StudentRepository companyRepository;

    public List<Student> getAllStudents(Integer pageNumber, Integer pageSize){
        Pageable p= PageRequest.of(pageNumber,pageSize);
        List<Student> pagePost=  this.companyRepository.findByIsDeletedFalse(p);
        return pagePost;
    }
    public Student getfindById(int id) {
        Optional<Student> optional = companyRepository.findById(id);
        if (((Optional<?>) optional).isPresent() && !optional.get().isDeleted()) {
            return optional.get();
        }
        throw new EntityNotFoundException("MyEntity with id " + id + " not found or has been deleted.");
    }

    public Student save(Student myEntity) {
        return companyRepository.save(myEntity);
    }

    public void deleteById(int id) {
        Student myEntity = getfindById(id);
        myEntity.setDeleted(true);
        companyRepository.save(myEntity);
    }
}
