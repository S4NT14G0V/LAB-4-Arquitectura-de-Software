package com.udea.graphqludea.repository;

import com.udea.graphqludea.entity.Equipo;
import com.udea.graphqludea.entity.Integracion;
import com.udea.graphqludea.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntegracionRepository extends JpaRepository<Integracion, Integer> {
    List<Integracion> findByEstudiante(Estudiante estudiante);
    List<Integracion> findByEquipo(Equipo equipo);
}
