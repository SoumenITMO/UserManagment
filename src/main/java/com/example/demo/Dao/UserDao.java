package com.example.demo.Dao;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

    User getFirstByUserNameAndUserPassword(String userName, String userPassword);

    @Query(value = "select * from user where user_type = 1", nativeQuery = true)
    List<User> getAllByUserType();

    @Modifying
    @Query(value = "delete from user where user_id = ?1 and user_type = 1", nativeQuery = true)
    int deleteUser(int userId);

    @Modifying
    @Query(value = "update user set user_password = ?1, firstname = ?2, lastname = ?3, email = ?4, address = ?5, " +
            "phone = ?6 where user_id = ?7", nativeQuery = true)
    int updateUser(String password, String firstname, String lastname, String email, String address, String phone, int userId);
}
