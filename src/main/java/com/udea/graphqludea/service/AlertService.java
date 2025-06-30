package com.udea.graphqludea.service;

import com.udea.graphqludea.entity.AlertEntity;
import com.udea.graphqludea.entity.AlertTypeEntity;
import com.udea.graphqludea.entity.PackageEntity;
import com.udea.graphqludea.entity.UserEntity;
import com.udea.graphqludea.interfaces.IAlertService;
import com.udea.graphqludea.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertService implements IAlertService {

    private final AlertRepository alertRepository;
    private final AlertTypeService alertTypeService;
    private final UserService userService;
    private final PackageService packageService;

    @Autowired
    public AlertService(AlertTypeService alertTypeService, AlertRepository alertRepository,  UserService userService, PackageService packageService) {
        this.alertTypeService = alertTypeService;
        this.alertRepository = alertRepository;
        this.userService = userService;
        this.packageService = packageService;
    }

    public AlertEntity createAlert(Long userId, Long packageId, int alertTypeId, String description){
        UserEntity userEntity = userService.findUserById(userId);
        PackageEntity packageEntity = packageService.findPackageById(packageId);
        AlertTypeEntity alertTypeEntity = alertTypeService.findById(alertTypeId);

        AlertEntity alertEntity = new AlertEntity();
        alertEntity.setUser(userEntity);
        alertEntity.setPackageEntity(packageEntity);
        alertEntity.setAlertTypeEntity(alertTypeEntity);
        alertEntity.setDescription(description);
        alertEntity.setRegisteredAt(LocalDateTime.now());
        return alertRepository.save(alertEntity);
    }

    public List<AlertEntity> findAll(){
        return alertRepository.findAllOrderByRegisteredAtDesc();
    }

    public List<AlertEntity> findAllAlertsByUserId(Long userId){
        return alertRepository.findAllByUserId(userId);
    }



}
