package com.udea.graphqludea.controller;

import com.udea.graphqludea.entity.AlertTypeEntity;
import com.udea.graphqludea.entity.PackageStatusEntity;
import com.udea.graphqludea.entity.RoleEntity;
import com.udea.graphqludea.interfaces.IAlertTypeService;
import com.udea.graphqludea.interfaces.IPackageStatusService;
import com.udea.graphqludea.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TypesController {

    private final IRoleService roleService;
    private final IPackageStatusService  packageStatusService;
    private final IAlertTypeService alertTypeService;

    @Autowired
    public TypesController(IRoleService roleService, IPackageStatusService  packageStatusService, IAlertTypeService alertTypeService){
        this.roleService = roleService;
        this.packageStatusService = packageStatusService;
        this.alertTypeService = alertTypeService;
    }

    @QueryMapping
    public List<RoleEntity> findAllRoles(){
        return roleService.findAll();
    }

    @QueryMapping
    public RoleEntity findRoleById(@Argument int id){
        return roleService.findById(id);
    }

    @QueryMapping
    public List<PackageStatusEntity> findAllPackagesStatus(){
        return packageStatusService.findAll();
    }

    @QueryMapping
    public PackageStatusEntity findPackageStatusById(@Argument int id){
        return packageStatusService.findById(id);
    }

    @QueryMapping
    public List<AlertTypeEntity> findAllAlertTypes(){
        return alertTypeService.findAll();
    }

    @QueryMapping
    public AlertTypeEntity findAlertTypeById(@Argument int id){
        return alertTypeService.findById(id);
    }
}
