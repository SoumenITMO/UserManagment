package com.example.demo.Services;

import com.example.demo.Dao.UserDao;
import com.example.demo.Dto.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class UpdateUserService {

    @Autowired
    UserDao userDao;

    public String userUpdate(UpdateUser updateUser) {

        return userDao.updateUser(updateUser.getPassword(), updateUser.getFirstname(), updateUser.getLastname(),
                updateUser.getEmail(), updateUser.getAddress(), updateUser.getPhone(),
                updateUser.getUserid()) == 1 ? "User Updated" : "Failed to update user";
    }
}
