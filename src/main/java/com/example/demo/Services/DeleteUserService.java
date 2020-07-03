package com.example.demo.Services;

import com.example.demo.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class DeleteUserService {

    @Autowired
    UserDao userDao;

    public ResponseEntity deleteUser(int userId) {
        if(userDao.deleteUser(userId) == 1) {
            return new ResponseEntity("User Deleted ...", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Failed to delete user ...", HttpStatus.OK);
        }
    }
}
