package com.example.demo.Entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "modules_mapper", schema = "tjtest")
public class ModulesMapper {
    private int mapperId;
    private int moduleId;
    private int userId;
    private Modules module;

    @Id
    @Column(name = "mapper_id")
    public int getMapperId() {
        return mapperId;
    }

    public void setMapperId(int mapperId) {
        this.mapperId = mapperId;
    }

    @Basic
    @Column(name = "module_id")
    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @OneToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "module_id", referencedColumnName = "module_id", insertable = false, updatable = false)
    public Modules getModule() {
        return this.module;
    }

    public void setModule(Modules modules) {
        this.module = modules;
    }
}
