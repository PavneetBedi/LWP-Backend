package com.companydetails.demo.Controllers;

import com.companydetails.demo.entities.Trainer;
import com.companydetails.demo.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping("/trainers")
    public ResponseEntity<List<Trainer>> getAllNotDeleted(@RequestParam(value = "pageNumber", defaultValue = "0",required = false) Integer pageNumber,
                                                          @RequestParam(value = "pageSize", defaultValue = "5",required = false) Integer pageSize) {
        List<Trainer> allCompanies = this.trainerService.getAllTrainers(pageNumber,pageSize);
        return new ResponseEntity<List<Trainer>>(allCompanies, HttpStatus.OK);
    }

    @GetMapping("/trainers/{id}")
    public Trainer findById(@PathVariable int id) {
        return trainerService.getfindById(id);
    }

    // new book handler
    @PostMapping("/trainers")
    public Trainer create(@RequestBody Trainer myEntity) {
        return trainerService.save(myEntity);
    }

    @PostMapping("/trainers/{id}")
    public Trainer update(@PathVariable int id, @RequestBody Trainer updatedTrainer) {
        return trainerService.save(updatedTrainer, id);
    }

    //delete book handler
    @DeleteMapping("/trainers/{id}")
    public void deleteById(@PathVariable int id) {
        trainerService.deleteById(id);
    }

    @GetMapping("/trainers/count")
    public long getTrainersCount() {
        return trainerService.getTrainerCount();
    }
}
