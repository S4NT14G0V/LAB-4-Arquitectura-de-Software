package com.udea.graphqludea.service;

import com.udea.graphqludea.entity.AlertTypeEntity;
import com.udea.graphqludea.interfaces.IAlertTypeService;
import com.udea.graphqludea.repository.AlertTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertTypeService implements IAlertTypeService {

    private final AlertTypeRepository alertTypeRepository;

    @Autowired
    public AlertTypeService(AlertTypeRepository alertTypeRepository) {
        this.alertTypeRepository = alertTypeRepository;
    }

    public List<AlertTypeEntity> findAll(){
        return alertTypeRepository.findAll();
    }

    public AlertTypeEntity findById(int id){
        return alertTypeRepository.findById(id).orElseThrow(()->new RuntimeException("AlertTypeEntity not found"));
    }
}
