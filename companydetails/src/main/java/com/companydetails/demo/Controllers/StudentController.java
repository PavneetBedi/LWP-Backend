package com.companydetails.demo.Controllers;

import com.companydetails.demo.entities.Student;
import com.companydetails.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class StudentController {
    @Autowired
    private StudentService companyService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllNotDeleted(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                                          @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {
        List<Student> allCompanies = this.companyService.getAllStudents(pageNumber, pageSize);
        return new ResponseEntity<List<Student>>(allCompanies, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public Student findById(@PathVariable int id) {
        return companyService.getfindById(id);
    }

    @PostMapping("/students")
    public Student create(@RequestBody Student myEntity) {
        return companyService.save(myEntity);
    }

    @PostMapping("/students/{id}")
    public Student update(@PathVariable int id, @RequestBody Student myEntity) {
        myEntity.setId(id);
        Student save = companyService.save(myEntity);
        return save;
    }

    @DeleteMapping("/students/{id}")
    public void deleteById(@PathVariable int id) {
        companyService.deleteById(id);
    }
}
