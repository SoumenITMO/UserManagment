package com.example.demo.Dao;

import com.example.demo.Entity.ModulesMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MapperDao extends JpaRepository<ModulesMapper, Long> {

    List<ModulesMapper> getAllByUserId(int userId);
    List<ModulesMapper> getAllBy();
    Optional<ModulesMapper> getByUserIdAndModuleId(int userId, int moduleId);

}
