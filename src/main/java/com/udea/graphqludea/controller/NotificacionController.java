package com.udea.graphqludea.controller;

import com.udea.graphqludea.entity.Notificacion;
import com.udea.graphqludea.service.NotificacionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class NotificacionController {

    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }


    @QueryMapping
    public List<Notificacion> notificaciones() {
        return notificacionService.findAll();
    }


    @QueryMapping
    public Notificacion notificacion(@Argument int id) {
        return notificacionService.findById(id);
    }

    @QueryMapping
    public List<Notificacion> notificacionesPorEstudiante(@Argument int estudianteId) {
        return notificacionService.findByEstudianteId(estudianteId);
    }

    @QueryMapping
    public List<Notificacion> notificacionesPorEquipo(@Argument int equipoId) {
        return notificacionService.findByEquipoId(equipoId);
    }

    @MutationMapping
    public Notificacion crearNotificacion(
            @Argument String plantilla,
            @Argument int estudianteId,
            @Argument int equipoId) {
        return notificacionService.createFromTemplate(plantilla, estudianteId, equipoId);
    }

    @MutationMapping
    public Notificacion marcarNotificacionComoLeida(@Argument int id) {
        return notificacionService.marcarComoLeida(id);
    }

    @MutationMapping
    public Boolean eliminarNotificacion(@Argument int id) {
        notificacionService.delete(id);
        return true;
    }
}
