package com.udea.graphqludea.interfaces;

import com.udea.graphqludea.dto.PackageCountByUserDTO;
import com.udea.graphqludea.entity.CustomResponseEntity;
import com.udea.graphqludea.entity.PackageEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface IPackageService {

    PackageEntity addPackage(PackageEntity packag);
    List<PackageEntity> findAllPackages();
    PackageEntity findPackageById(Long id);
    PackageEntity findPackageByTrackingCode(String trackingCode);
    CustomResponseEntity updatePackage(PackageEntity packag);
    CustomResponseEntity deletePackageById(Long id);

    //TODO: Check these lines of codes
    List<PackageEntity> findPackagesByDateRange (LocalDateTime startDate, LocalDateTime endDate);
    PackageCountByUserDTO findPackageCountByUserId (Long userId);
    List<PackageEntity> findPackagesByStatusIn(List<Integer> packageStatuses);
    List<PackageCountByUserDTO> findCountByAllUsers();
    List<PackageEntity> findAllPackagesByUserId(Long userId);
    List<PackageEntity> findAllPackagesByUbication(String origin, String destination);
}
