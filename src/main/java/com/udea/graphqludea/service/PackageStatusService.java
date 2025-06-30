package com.udea.graphqludea.service;

import com.udea.graphqludea.entity.PackageStatusEntity;
import com.udea.graphqludea.interfaces.IPackageStatusService;
import com.udea.graphqludea.repository.PackageStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageStatusService implements IPackageStatusService {

    private final PackageStatusRepository packageStatusRepository;

    @Autowired
    public PackageStatusService(PackageStatusRepository packageStatusRepository) {
        this.packageStatusRepository = packageStatusRepository;
    }

    public List<PackageStatusEntity> findAll() {
        return packageStatusRepository.findAll();
    }

    public PackageStatusEntity findById(int id) {
        return packageStatusRepository.findById(id).orElseThrow(()->new RuntimeException("Package Status not found"));
    }
}
