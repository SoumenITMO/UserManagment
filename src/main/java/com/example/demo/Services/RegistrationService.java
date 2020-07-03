package com.example.demo.Services;

import com.example.demo.Dao.UserDao;
import com.example.demo.Dto.RegisterUser;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    UserDao userDao;

    public void doRegistration(RegisterUser registerUser) {

        User newUser = new User();

        newUser.setFirstname(registerUser.getFirstname());
        newUser.setLastname(registerUser.getLastname());
        newUser.setAddress(registerUser.getAddress());
        newUser.setEmail(registerUser.getEmail());
        newUser.setPhone(registerUser.getPhone());
        newUser.setUserName(registerUser.getUsername());
        newUser.setUserPassword(registerUser.getPassword());
        newUser.setUserType(1);

        userDao.save(newUser);
    }
}
