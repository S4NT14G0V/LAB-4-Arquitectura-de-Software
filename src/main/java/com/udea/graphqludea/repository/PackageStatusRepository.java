package com.udea.graphqludea.repository;

import com.udea.graphqludea.entity.PackageStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageStatusRepository extends JpaRepository<PackageStatusEntity, Integer> {
}
