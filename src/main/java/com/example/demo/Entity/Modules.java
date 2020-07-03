package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "modules", schema = "tjtest")
public class Modules {
    private int moduleId;
    private String moduleName;

    @Id
    @Column(name = "module_id")
    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "module_name")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
