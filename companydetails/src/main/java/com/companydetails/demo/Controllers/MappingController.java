package com.companydetails.demo.Controllers;

import com.companydetails.demo.entities.Mapping;
import com.companydetails.demo.services.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class MappingController {
    @Autowired
    private MappingService mappingService;
    @GetMapping("/mapping")
    public ResponseEntity<List<Mapping>> getAllNotDeleted(@RequestParam(value = "pageNumber", defaultValue = "0",required = false) Integer pageNumber,
                                                          @RequestParam(value = "pageSize", defaultValue = "5",required = false) Integer pageSize) {
        List<Mapping> allCompanies = this.mappingService.getAlldetails(pageNumber,pageSize);
        return new ResponseEntity<List<Mapping>>(allCompanies, HttpStatus.OK);
    }

    @GetMapping("/mapping/{id}")
    public ResponseEntity<Mapping> findById(@PathVariable int id) {
        Mapping mapping = mappingService.getfindById(id);
        return ResponseEntity.ok(mapping);
    }

    @PostMapping("/mapping")
    public ResponseEntity<Mapping> create(@RequestBody Mapping mapping) {
        Mapping createdMapping = mappingService.save(mapping);
        return new ResponseEntity<>(createdMapping, HttpStatus.CREATED);
    }

    @PostMapping ("/mapping/{id}")
    public Mapping update(@PathVariable int id, @RequestBody Mapping myEntity) {
        myEntity.setId(id);
        Mapping save = mappingService.save(myEntity);
        return save;
    }
    @DeleteMapping("/mapping/{id}")
    public void deleteById(@PathVariable int id) {
        mappingService.deleteById(id);
    }
}
