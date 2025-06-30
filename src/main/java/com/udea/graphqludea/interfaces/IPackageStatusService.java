package com.udea.graphqludea.interfaces;

import com.udea.graphqludea.entity.PackageStatusEntity;

import java.util.List;

public interface IPackageStatusService {

    List<PackageStatusEntity> findAll();
    PackageStatusEntity findById(int id);
}
