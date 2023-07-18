package com.companydetails.demo.services;

import com.companydetails.demo.dao.TrainingRepository;
import com.companydetails.demo.entities.Student;
import com.companydetails.demo.entities.Training;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TrainingService {
    @Autowired
    private TrainingRepository trainingRepository;

    public Optional<Training> findById(int id) {
        return trainingRepository.findById(id);
    }
    public List<Training> getAllTraining(Integer pageNumber, Integer pageSize){

        Pageable p= PageRequest.of(pageNumber,pageSize);
        List<Training> pagePost=this.trainingRepository.findByIsDeletedFalse(p);
        return pagePost;
    }

    public Training getfindById(int id){
        Optional<Training> optional = trainingRepository.findById(id);
        if (((Optional<?>) optional).isPresent() && !optional.get().isDeleted()) {
            return optional.get();
        }
        throw new EntityNotFoundException("MyEntity with id " + id + " not found or has been deleted.");
    }

    public Training save(Training myEntity) {
        return trainingRepository.save(myEntity);
    }


    public Training save(Training updatedTraining, int trainingId) {
        Optional<Training> optionalExistingTraining = trainingRepository.findById(trainingId);

        if (optionalExistingTraining.isPresent()) {
            Training existingTraining = optionalExistingTraining.get();

            // Get the existing students
            List<Student> existingStudents = existingTraining.getStudents();

            // Get the updated students
            List<Student> updatedStudents = updatedTraining.getStudents();

            // Remove students that are not present in the updated list
            existingStudents.retainAll(updatedStudents);

            // Add new students that are not already in the existing list
            for (Student updatedStudent : updatedStudents) {
                if (!existingStudents.contains(updatedStudent)) {
                    existingStudents.add(updatedStudent);
                }
            }

            return trainingRepository.save(existingTraining);
        }

        return null; // Or throw an exception indicating that the training entity with the specified ID was not found
    }

    public void deleteById(int id) {
        Training myEntity = getfindById(id);
        myEntity.setDeleted(true);
        trainingRepository.save(myEntity);
    }

    public long getTrainingCount() {
        return trainingRepository.count();
    }
}


