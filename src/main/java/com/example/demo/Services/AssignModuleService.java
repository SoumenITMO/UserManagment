package com.example.demo.Services;

import com.example.demo.Dao.MapperDao;
import com.example.demo.Dto.AssignModuleUser;
import com.example.demo.Entity.ModulesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class AssignModuleService {

    @Autowired
    MapperDao mapperDao;

    public ResponseEntity assignModule(AssignModuleUser assignModuleUser) {

        if(mapperDao.getByUserIdAndModuleId(assignModuleUser.getUserid(),
                assignModuleUser.getModuleid()).isPresent()) {
            return new ResponseEntity("Already Assigned ...", HttpStatus.OK);
        }

        else {
            ModulesMapper modulesMapper = new ModulesMapper();

            modulesMapper.setUserId(assignModuleUser.getUserid());
            modulesMapper.setModuleId(assignModuleUser.getModuleid());

            mapperDao.save(modulesMapper);
            return new ResponseEntity("Assigned Module", HttpStatus.OK);
        }
    }
}
