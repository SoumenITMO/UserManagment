package com.example.demo.Dto;

import com.example.demo.Entity.Modules;
import com.example.demo.Entity.User;
import java.util.List;

public class ResponseAdmin {

    private String fistname;
    private String lastname;
    private String welcomeMSG;
    private List<User> users;
    private List<Modules> modules;

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getWelcomeMSG() {
        return welcomeMSG;
    }

    public void setWelcomeMSG(String welcomeMSG) {
        this.welcomeMSG = welcomeMSG;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Modules> getModules() {
        return modules;
    }

    public void setModules(List<Modules> modules) {
        this.modules = modules;
    }
}
