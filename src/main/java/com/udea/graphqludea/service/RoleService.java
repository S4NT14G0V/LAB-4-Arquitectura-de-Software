package com.udea.graphqludea.service;

import com.udea.graphqludea.entity.RoleEntity;
import com.udea.graphqludea.interfaces.IRoleService;
import com.udea.graphqludea.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleEntity> findAll(){
        return roleRepository.findAll();
    }

    public RoleEntity findById(int id){
        return roleRepository.findById(id).orElseThrow(()->new RuntimeException("Role not found"));
    }
}
