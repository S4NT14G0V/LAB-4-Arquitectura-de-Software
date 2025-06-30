package com.udea.graphqludea.interfaces;

import com.udea.graphqludea.entity.AlertEntity;

import java.util.List;

public interface IAlertService {

    AlertEntity createAlert(Long userId, Long packageId, int alertTypeId, String description);
    List<AlertEntity> findAll();
    List<AlertEntity> findAllAlertsByUserId(Long userId);

}
