package com.udea.graphqludea.interfaces;

import com.udea.graphqludea.entity.AlertTypeEntity;

import java.util.List;

public interface IAlertTypeService {

    List<AlertTypeEntity> findAll();
    AlertTypeEntity findById(int id);
}
