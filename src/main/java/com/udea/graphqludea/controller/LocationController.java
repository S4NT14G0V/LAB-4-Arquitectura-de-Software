package com.udea.graphqludea.controller;

import com.udea.graphqludea.entity.CustomResponseEntity;
import com.udea.graphqludea.entity.LocationEntity;
import com.udea.graphqludea.interfaces.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LocationController {

    private final ILocationService locationService;

    @Autowired
    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @MutationMapping
    public LocationEntity addLocation(@Argument LocationEntity location){
        return locationService.addLocation(location);
    }

    @QueryMapping
    public List<LocationEntity> findAllLocations() {
        return locationService.findAllLocations();
    }

    @QueryMapping
    public LocationEntity findLocationById(@Argument Long id) {
        return locationService.findLocationById(id);
    }

    @MutationMapping
    public CustomResponseEntity updateLocation(@Argument LocationEntity location){
        return locationService.updateLocation(location);
    }

    @MutationMapping
    public CustomResponseEntity deleteLocationById(@Argument Long id){
        return locationService.deleteLocationById(id);
    }

    @QueryMapping
    public List<LocationEntity> findAllLocationsByPackageId(@Argument Long packageId){
        return locationService.findAllLocationsByPackageEntityId(packageId);
    }

    @QueryMapping
    public LocationEntity findLastLocationByPackageId(@Argument Long packageId){
        return locationService.findLastLocationByPackageEntityId(packageId);
    }

    @QueryMapping
    public List<LocationEntity> findAllLocationsByUserId(@Argument Long userId){
        return locationService.findAllLocationsByUserId(userId);
    }
}
