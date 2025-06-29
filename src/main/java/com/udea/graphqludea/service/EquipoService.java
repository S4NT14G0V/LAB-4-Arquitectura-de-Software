package com.udea.graphqludea.service;

import com.udea.graphqludea.entity.Curso;
import com.udea.graphqludea.entity.Equipo;
import com.udea.graphqludea.repository.CursoRepository;
import com.udea.graphqludea.repository.EquipoRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Equipo findById(Integer id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipo no encontrado"));
    }

    public Equipo save(Equipo equipo, Integer cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado"));
        equipo.setCurso(curso);
        equipo.setFecha_creacion(LocalDateTime.now());
        return equipoRepository.save(equipo);
    }

    public Equipo update(Integer id, Equipo equipoDetails) {
        Equipo equipo = findById(id);
        equipo.setNombre(equipoDetails.getNombre());
        return equipoRepository.save(equipo);
    }

    public void deleteById(Integer id) {
        equipoRepository.deleteById(id);
    }

    public List<Equipo> findByCursoId(Integer cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado"));
        return equipoRepository.findByCurso(curso);
    }
}
