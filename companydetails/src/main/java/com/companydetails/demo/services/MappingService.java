package com.companydetails.demo.services;

import com.companydetails.demo.dao.MappingRepository;
import com.companydetails.demo.dao.TrainerRepository;
import com.companydetails.demo.entities.Mapping;
import com.companydetails.demo.entities.Trainer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MappingService {
    @Autowired
    private MappingRepository mappingRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    //get all books
    public List<Mapping> getAlldetails(Integer pageNumber, Integer pageSize){
        Pageable p= PageRequest.of(pageNumber,pageSize);
        List<Mapping> pagePost=  this.mappingRepository.findByIsDeletedFalse(p);
        return pagePost;
    }

    public Mapping getfindById(int id) {
        Optional<Mapping> optional = mappingRepository.findById(id);
        if (optional.isPresent() && !optional.get().isDeleted()) {
            Mapping mapping = optional.get();
            Trainer trainer = trainerRepository.findById(mapping.getTrainingid())
                    .orElseThrow(() -> new EntityNotFoundException("Trainer with trainingId " + mapping.getTrainingid() + " not found"));
            mapping.setTrainer(trainer);
            return mapping;
        }
        throw new EntityNotFoundException("Mapping with id " + id + " not found or has been deleted.");
    }

    public Mapping save(Mapping myEntity) {
        return mappingRepository.save(myEntity);
    }

    public void deleteById(int id) {
        Mapping myEntity = getfindById(id);
        myEntity.setDeleted(true);
        mappingRepository.save(myEntity);
    }

}
