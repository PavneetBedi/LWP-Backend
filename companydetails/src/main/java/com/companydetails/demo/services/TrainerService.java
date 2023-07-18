package com.companydetails.demo.services;

import com.companydetails.demo.dao.TrainerRepository;
import com.companydetails.demo.entities.Trainer;
import com.companydetails.demo.entities.Training;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    public Optional<Trainer> findById(int id) {
        return trainerRepository.findById(id);
    }

    //get all Trainers
    public List<Trainer> getAllTrainers(Integer pageNumber, Integer pageSize){
        Pageable p= PageRequest.of(pageNumber,pageSize);
        List<Trainer> pagePost=this.trainerRepository.findByIsDeletedFalse(p);
        return pagePost;
    }

    //get single trainer by id
    public Trainer getfindById(int id){
        Optional<Trainer> optional = trainerRepository.findById(id);
        if (((Optional<?>) optional).isPresent() && !optional.get().isDeleted()) {
            return optional.get();
        }
        throw new EntityNotFoundException("MyEntity with id " + id + " not found or has been deleted.");
    }

    public Trainer save(Trainer myEntity) {
        return trainerRepository.save(myEntity);
    }

    public Trainer save(Trainer updatedTrainer, int trainerId) {
        Optional<Trainer> optionalExistingTrainer = trainerRepository.findById(trainerId);

        if (optionalExistingTrainer.isPresent()) {
            Trainer existingTrainer = optionalExistingTrainer.get();

            // Get the existing trainings
            List<Training> existingTrainings = existingTrainer.getTrainings();

            // Get the updated trainings
            List<Training> updatedTrainings = updatedTrainer.getTrainings();

            // Remove trainings that are not present in the updated list
            existingTrainings.retainAll(updatedTrainings);

            // Add new trainings that are not already in the existing list
            for (Training updatedTraining : updatedTrainings) {
                if (!existingTrainings.contains(updatedTraining)) {
                    existingTrainings.add(updatedTraining);
                }
            }

            return trainerRepository.save(existingTrainer);
        }

        return null; // Or throw an exception indicating that the trainer entity with the specified ID was not found
    }

    public void deleteById(int id) {
        Trainer myEntity = getfindById(id);
        myEntity.setDeleted(true);
        trainerRepository.save(myEntity);
    }

    public long getTrainerCount() {
        return trainerRepository.count();
    }

}

