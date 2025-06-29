package com.udea.graphqludea.repository;

import com.udea.graphqludea.entity.Curso;
import com.udea.graphqludea.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    List<Equipo> findByCurso(Curso curso);
}

