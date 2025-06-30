package com.udea.graphqludea.interfaces;

import com.udea.graphqludea.entity.CustomResponseEntity;
import com.udea.graphqludea.entity.LocationEntity;

import java.util.List;

public interface ILocationService {

    LocationEntity addLocation(LocationEntity locationEntity);
    List<LocationEntity> findAllLocations();
    LocationEntity findLocationById(Long id);
    CustomResponseEntity updateLocation(LocationEntity locationEntity);
    CustomResponseEntity deleteLocationById(Long id);
    List<LocationEntity> findAllLocationsByPackageEntityId(Long packageId);
    LocationEntity findLastLocationByPackageEntityId(Long packageId);
    List<LocationEntity> findAllLocationsByUserId(Long userId);
    //findLastLocationByPackage

}
