package com.udea.graphqludea.controller;

import com.example.InnoSistemas.entity.Estudiante;
import com.example.InnoSistemas.entity.Integracion;
import com.example.InnoSistemas.service.EstudianteService;
import com.example.InnoSistemas.service.IntegracionService;
import com.example.InnoSistemas.service.NotificacionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class IntegracionController {

    private final IntegracionService integracionService;

    private final NotificacionService notificacionService;

    private final EstudianteService estudianteService;

    public IntegracionController(IntegracionService integracionService, NotificacionService notificacionService, EstudianteService estudianteService) {
        this.integracionService = integracionService;
        this.notificacionService = notificacionService;
        this.estudianteService = estudianteService;
    }

    @PreAuthorize("isAuthenticated()")
    @QueryMapping
    public List<Integracion> integraciones() {
        return integracionService.findAll();
    }

    @PreAuthorize("isAuthenticated()")
    @QueryMapping
    public Integracion integracion(@Argument int id) {
        return integracionService.findById(id);
    }

    @PreAuthorize("isAuthenticated()")
    @QueryMapping
    public List<Integracion> integracionesPorEstudiante(@Argument int estudianteId) {
        return integracionService.findByEstudianteId(estudianteId);
    }

    @PreAuthorize("isAuthenticated()")
    @QueryMapping
    public List<Integracion> integracionesPorEquipo(@Argument int equipoId) {
        return integracionService.findByEquipoId(equipoId);
    }

    @PreAuthorize("permitAll()")
    @MutationMapping
    public Integracion crearIntegracion(@Argument int estudianteId, @Argument int equipoId, @Argument int rolId) {
        Integracion integracion = integracionService.save(estudianteId, equipoId, rolId);

//        notificacionService.createFromTemplate(
//                "Asignación a equipo",
//                estudianteId,
//                equipoId
//        );

        return integracion;
    }

    @MutationMapping
    public Boolean eliminarIntegracion(@Argument int id, @Argument String razon) {
        Integracion integracion = integracionService.findById(id);

//        notificacionService.createFromTemplate(
//                "Expulsión del equipo",
//                integracion.getEstudiante().getId(),
//                integracion.getEquipo().getId()
//        );

        integracionService.delete(id);
        return true;
    }



}
