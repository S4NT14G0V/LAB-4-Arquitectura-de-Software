package com.udea.graphqludea.controller;

import com.udea.graphqludea.entity.Curso;
import com.udea.graphqludea.entity.Estudiante;
import com.udea.graphqludea.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EstudianteController {

    private final EstudianteService estudianteService;


    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @QueryMapping
    public List<Estudiante> estudiantes() {
        return estudianteService.findAll();
    }

    @QueryMapping
    public Estudiante estudiante(@Argument int id) {
        return estudianteService.findById(id);
    }

    @QueryMapping
    public List<Curso> cursosPorEstudiante(@Argument int estudianteId) {
        return estudianteService.getCursosByEstudianteId(estudianteId);
    }

    @MutationMapping
    public Estudiante crearEstudiante(@Argument("estudiante") Estudiante input) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(input.getNombre());
        estudiante.setApellidos(input.getApellidos());
        estudiante.setEmail(input.getEmail());
        estudiante.setPassword(input.getPassword()); // Sin encriptación
        return estudianteService.save(estudiante);
    }


//    @MutationMapping
//    public AuthResponse login(@Argument AuthRequest input) {
//        try {
//            // Verificar si el usuario existe primero
//            Optional<Estudiante> estudiante = estudianteService.findByEmail(input.getEmail());
//            if (estudiante.isEmpty()) {
//                return new AuthResponse("Usuario no encontrado", false);
//            }
//
//            // Autenticación
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword())
//            );
//
//            // Generación del token JWT
//            final UserDetails userDetails = userDetailsService.loadUserByUsername(input.getEmail());
//            final String jwt = jwtUtil.generateToken(userDetails.getUsername());
//
//            return new AuthResponse(jwt);
//        } catch (BadCredentialsException e) {
//            return new AuthResponse("Contraseña incorrecta", false);
//        } catch (Exception e) {
//            return new AuthResponse("Error durante el login: " + e.getMessage(), false);
//        }
//    }
}
