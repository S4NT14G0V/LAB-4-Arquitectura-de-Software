package com.udea.graphqludea.controller;

import com.udea.graphqludea.entity.AlertEntity;
import com.udea.graphqludea.interfaces.IAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AlertController {

    private final IAlertService alertService;

    @Autowired
    public AlertController(IAlertService alertService) {
        this.alertService = alertService;
    }

    @QueryMapping
    public List<AlertEntity> findAllAlerts(){
        return alertService.findAll();
    }

    @QueryMapping
    public List<AlertEntity> findAllAlertsByUserId(@Argument Long id){
        return alertService.findAllAlertsByUserId(id);
    }
}
