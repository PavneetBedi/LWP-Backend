package com.companydetails.demo.Controllers;

import com.companydetails.demo.DTO.LoginDTO;
import com.companydetails.demo.entities.User;
import com.companydetails.demo.response.LoginResponse;
import com.companydetails.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService uService;
    @PostMapping("/register")
    public String saveadmin(@RequestBody User myEntity) {
        String id=uService.addUser(myEntity);
        return id;
    }

    @PostMapping("/logi")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginResponse loginMesage=uService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMesage);
    }
}

