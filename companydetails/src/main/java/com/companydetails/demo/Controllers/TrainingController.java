package com.companydetails.demo.Controllers;

import com.companydetails.demo.entities.Student;
import com.companydetails.demo.entities.Trainer;
import com.companydetails.demo.entities.Training;
import com.companydetails.demo.services.TrainerService;
import com.companydetails.demo.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/training")
    public ResponseEntity<List<Training>> getAllNotDeleted(@RequestParam(value = "pageNumber", defaultValue = "0",required = false) Integer pageNumber,
                                                            @RequestParam(value = "pageSize", defaultValue = "5",required = false) Integer pageSize) {
        List<Training> allCompanies = this.trainingService.getAllTraining(pageNumber,pageSize);
        return new ResponseEntity<List<Training>>(allCompanies, HttpStatus.OK);
    }

    @GetMapping("/training/{id}")
    public Training findById(@PathVariable int id) {
        return trainingService.getfindById(id);
    }

//    @PostMapping("/training")
//    public Training create(@RequestBody Training myEntity){
//        return trainingService.save(myEntity);
//    }
    @PostMapping("/training")
    public ResponseEntity<Training> create(@RequestBody Training myEntity) {
        Training createdTraining = trainingService.save(myEntity);
        return new ResponseEntity<>(createdTraining, HttpStatus.CREATED);
    }


    @GetMapping("/training/count")
    public long getTrainingCount() {
        return trainingService.getTrainingCount();
    }

    @PostMapping("/training/{id}")
    public Training update(@PathVariable int id, @RequestBody Training updatedTraining) {
        return trainingService.save(updatedTraining, id);
    }

    @DeleteMapping("/training/{id}")
    public void deleteById(@PathVariable int id) {
        trainingService.deleteById(id);
    }

    @GetMapping("/training/{id}/students")
    public ResponseEntity<List<Student>> getTrainingStudents(@PathVariable("id") int id) {
        Optional<Training> trainingOptional = trainingService.findById(id);

        if (trainingOptional.isPresent()) {
            Training training = trainingOptional.get();
            List<Student> students = training.getStudents();

            return ResponseEntity.ok(students);
        }

        return ResponseEntity.notFound().build();
    }


    //final code
//    @GetMapping("/trainings/{id}")
//    public ResponseEntity<Training> getTrainingWithTrainerName(@PathVariable("id") int id) {
//        Optional<Training> trainingOptional = trainingService.findById(id);
//
//        if (trainingOptional.isPresent()) {
//            Training training = trainingOptional.get();
//
//            int trainerId = training.getTrainer_id();
//            Optional<Trainer> trainerOptional = trainerService.findById(trainerId);
//
//            if (trainerOptional.isPresent()) {
//                Trainer trainer = trainerOptional.get();
//                String trainerName = trainer.getTrainername();
//
//                // Set the trainer name in the training entity
//                training.setTrainername(trainerName);
//
//                // Return the training entity with the trainer name
//                return ResponseEntity.ok(training);
//            } else {
//                return ResponseEntity.ok().body(training); // No Trainer Found, return training details without trainer name
//            }
//        }
//
//        return ResponseEntity.notFound().build();
//    }
    @GetMapping("/trainings/{id}")
    public ResponseEntity<Training> getTrainingWithTrainerName(@PathVariable("id") int id) {
        Optional<Training> trainingOptional = trainingService.findById(id);

        if (trainingOptional.isPresent()) {
            Training training = trainingOptional.get();

            int trainerId = training.getTrainer_id();
            Optional<Trainer> trainerOptional = trainerService.findById(trainerId);

            if (trainerOptional.isPresent()) {
                Trainer trainer = trainerOptional.get();
                String trainerName = trainer.getTrainername();

                // Set the trainer name in the training entity
                training.setTrainername(trainerName);

                // Return the training entity with the trainer name
                return ResponseEntity.ok(training);
            } else {
                return ResponseEntity.ok().body(training); // No Trainer Found, return training details without trainer name
            }
        }

        return ResponseEntity.notFound().build();
    }

}
