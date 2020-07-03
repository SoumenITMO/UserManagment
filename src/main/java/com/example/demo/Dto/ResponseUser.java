package com.example.demo.Dto;

import com.example.demo.Entity.ModulesMapper;
import java.util.List;

public class ResponseUser {

    private String firstname;
    private String lastname;
    private List<String> modules;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<String> getModules() {
        return modules;
    }

    public void setModules(List<String> modules) {
        this.modules = modules;
    }
}
