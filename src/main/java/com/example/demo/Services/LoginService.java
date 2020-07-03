package com.example.demo.Services;

import com.example.demo.Dao.MapperDao;
import com.example.demo.Dao.ModulesDao;
import com.example.demo.Dao.UserDao;
import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.ResponseAdmin;
import com.example.demo.Dto.ResponseUser;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModulesDao modulesDao;

    @Autowired
    private MapperDao mapperDao;

    private List<String> modules;

    public LoginService(UserDao userDao) {
        this.userDao = userDao;
    }

    public ResponseEntity doLogin(LoginDto loginDto) {

        ResponseUser responseUser = new ResponseUser();
        ResponseAdmin responseAdmin = new ResponseAdmin();

        User userdata = userDao.getFirstByUserNameAndUserPassword(loginDto.getUserName(), loginDto.getPassword());

        if(!mapperDao.getAllByUserId(userdata.getUserId()).isEmpty()) {
            modules = mapperDao.getAllByUserId(userdata.getUserId()).stream()
                    .map(getModuleName -> getModuleName.getModule().getModuleName()).collect(Collectors.toList());
        }

        if(userdata != null) {
            if(userdata.getUserType() == 0) {

                responseAdmin.setFistname(userdata.getFirstname());
                responseAdmin.setLastname(userdata.getLastname());
                responseAdmin.setModules(modulesDao.getAllBy());
                responseAdmin.setUsers(userDao.getAllByUserType());
                responseAdmin.setWelcomeMSG("Welcome " + responseAdmin.getFistname() + " " + responseAdmin.getLastname());
                return new ResponseEntity(responseAdmin, HttpStatus.OK);
            }

            if(userdata.getUserType() == 1) {
                responseUser.setFirstname(userdata.getFirstname());
                responseUser.setLastname(userdata.getLastname());
                responseUser.setModules(modules);
                responseAdmin.setWelcomeMSG("Welcome " + responseAdmin.getFistname() + " " + responseAdmin.getLastname());
                return new ResponseEntity(responseUser, HttpStatus.OK);
            }
        }

        else {
            return new ResponseEntity("Login Failed ...", HttpStatus.OK);
        }
        return null;
    }
}
