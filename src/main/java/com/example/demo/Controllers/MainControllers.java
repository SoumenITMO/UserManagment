package com.example.demo.Controllers;

import com.example.demo.Dto.AssignModuleUser;
import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.RegisterUser;
import com.example.demo.Dto.UpdateUser;
import com.example.demo.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainControllers {

    @Autowired
    LoginService loginService;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    DeleteUserService deleteUserService;

    @Autowired
    UpdateUserService updateUserService;

    @Autowired
    AssignModuleService assignModuleService;

    @RequestMapping(value = "dologin", method = RequestMethod.POST)
    public ResponseEntity loginController(@RequestBody LoginDto loginDto) {
        return loginService.doLogin(loginDto);
    }

    @RequestMapping(value = "createuser", method = RequestMethod.POST)
    public void createUserController(@RequestBody RegisterUser registerUser) {
        registrationService.doRegistration(registerUser);
    }

    @RequestMapping(value = "assignmodule", method = RequestMethod.POST)
    public ResponseEntity assignModule(@RequestBody AssignModuleUser assignModuleUser) {
        return assignModuleService.assignModule(assignModuleUser);
    }

    @RequestMapping(value = "updateuser", method = RequestMethod.PUT)
    public ResponseEntity updateUserController(@RequestBody UpdateUser updateUser) {
        return new ResponseEntity(updateUserService.userUpdate(updateUser), HttpStatus.OK);
    }

    @RequestMapping(value = "deleteuser/{userid}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("userid") int userId) {
        return deleteUserService.deleteUser(userId);
    }
}
