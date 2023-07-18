package com.companydetails.demo.Controllers;

import com.companydetails.demo.dao.CompanyRepository;
import com.companydetails.demo.entities.Company;
import com.companydetails.demo.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllNotDeleted(@RequestParam(value = "pageNumber", defaultValue = "0",required = false) Integer pageNumber,
                                                          @RequestParam(value = "pageSize", defaultValue = "5",required = false) Integer pageSize) {
        List<Company> allCompanies = this.companyService.getAllCompanies(pageNumber,pageSize);
        return new ResponseEntity<List<Company>>(allCompanies, HttpStatus.OK);
    }

    @GetMapping("/companies/{id}")
    public Company findById(@PathVariable int id) {
        return companyService.getfindById(id);
    }

    @GetMapping("/companies/count")
    public ResponseEntity<Long> getRowCount() {
        long rowCount = companyService.getRowCount();
        return new ResponseEntity<>(rowCount, HttpStatus.OK);
    }

    @PostMapping("/companies")
    public Company create(@RequestBody Company myEntity) {
        return companyService.save(myEntity);
    }

    @PostMapping ("/companies/{id}")
    public Company update(@PathVariable int id, @RequestBody Company myEntity) {
        myEntity.setId(id);
        Company save = companyService.save(myEntity);
        return save;
    }
    @DeleteMapping("/companies/{id}")
    public void deleteById(@PathVariable int id) {
        companyService.deleteById(id);
    }
}


