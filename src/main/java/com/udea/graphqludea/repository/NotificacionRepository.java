package com.udea.graphqludea.repository;

import com.udea.graphqludea.entity.Equipo;
import com.udea.graphqludea.entity.Estudiante;
import com.udea.graphqludea.entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    List<Notificacion> findByEstudiante(Estudiante estudiante);
    List<Notificacion> findByEquipo(Equipo equipo);
}
