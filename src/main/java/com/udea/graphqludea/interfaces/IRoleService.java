package com.udea.graphqludea.interfaces;

import com.udea.graphqludea.entity.RoleEntity;

import java.util.List;

public interface IRoleService {

    List<RoleEntity> findAll();
    RoleEntity findById(int id);

}
