package com.example.demo.Dao;

import com.example.demo.Entity.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ModulesDao extends JpaRepository<Modules, Long> {

    List<Modules> getAllBy();
}
