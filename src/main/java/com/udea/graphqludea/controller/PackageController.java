package com.udea.graphqludea.controller;

import com.udea.graphqludea.dto.PackageCountByUserDTO;
import com.udea.graphqludea.entity.CustomResponseEntity;
import com.udea.graphqludea.entity.PackageEntity;
import com.udea.graphqludea.interfaces.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PackageController {

    private final IPackageService packageService;

    @Autowired
    public PackageController(IPackageService packageService) {
        this.packageService = packageService;
    }

    @MutationMapping
    public PackageEntity addPackage(@Argument PackageEntity packageEntity){
        return packageService.addPackage(packageEntity);
    }

    @QueryMapping
    public List<PackageEntity> findAllPackages() {
        return packageService.findAllPackages();
    }

    @QueryMapping
    public PackageEntity findPackageById(@Argument Long id) {
        return packageService.findPackageById(id);
    }

    @MutationMapping
    public CustomResponseEntity updatePackage(@Argument PackageEntity packageEntity){
        return packageService.updatePackage(packageEntity);
    }

    @MutationMapping
    public CustomResponseEntity deletePackageById(@Argument Long id){
        return packageService.deletePackageById(id);
    }

    @QueryMapping
    public PackageEntity findPackageByTrackingCode(@Argument String trackingCode){
        return packageService.findPackageByTrackingCode(trackingCode);
    }

    @QueryMapping
    public List<PackageEntity> findPackagesByDateRange(@Argument LocalDateTime startDate, @Argument LocalDateTime endDate){
        return packageService.findPackagesByDateRange(startDate, endDate);
    }

    @QueryMapping
    public PackageCountByUserDTO findPackageCountByUserId (@Argument Long userId) {
        return packageService.findPackageCountByUserId(userId);
    }

    @QueryMapping
    public List<PackageEntity> findPackagesByStatusIn(@Argument List<Integer> packageStatuses) {
        return packageService.findPackagesByStatusIn(packageStatuses);
    }

    @QueryMapping
    public List<PackageCountByUserDTO> findPackageCountByAllUsers() {
        return packageService.findCountByAllUsers();
    }

    @QueryMapping
    public List<PackageEntity> findAllPackagesByUserId(@Argument Long userId) {
        return packageService.findAllPackagesByUserId(userId);
    }

    @QueryMapping
    public List<PackageEntity> findAllPackagesByUbication(@Argument String origin, @Argument String destination) {
        return packageService.findAllPackagesByUbication(origin, destination);
    }
}
