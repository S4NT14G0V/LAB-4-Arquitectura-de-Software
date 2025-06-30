package com.udea.graphqludea.repository;

import com.udea.graphqludea.entity.AlertTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertTypeRepository extends JpaRepository<AlertTypeEntity, Integer> {
}
