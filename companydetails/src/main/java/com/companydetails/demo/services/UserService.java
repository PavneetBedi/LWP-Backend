package com.companydetails.demo.services;

import com.companydetails.demo.DTO.LoginDTO;
import com.companydetails.demo.dao.UserRepo;
import com.companydetails.demo.entities.User;
import com.companydetails.demo.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(User myEntity) {

        User user = new User(
                myEntity.getUserid(),
                myEntity.getMobilenumber(),
                myEntity.getEmail(),
                this.passwordEncoder.encode(myEntity.getPassword())
        );
        userRepository.save(user);
        return user.getEmail();
    }

    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User employee1;
        employee1 = userRepository.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exits", false);
        }
    }
}
