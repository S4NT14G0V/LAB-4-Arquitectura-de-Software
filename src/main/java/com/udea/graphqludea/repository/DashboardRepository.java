package com.udea.graphqludea.repository;

import com.udea.graphqludea.entity.Equipo;
import com.udea.graphqludea.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Integer> {
    List<Dashboard> findByEquipo(Equipo equipo);
}
