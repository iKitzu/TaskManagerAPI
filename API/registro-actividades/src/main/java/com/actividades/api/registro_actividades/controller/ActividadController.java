package com.actividades.api.registro_actividades.controller;

import com.actividades.api.registro_actividades.model.Actividad;
import com.actividades.api.registro_actividades.repository.ActividadRepository;
import com.actividades.api.registro_actividades.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private ActividadRepository actividadRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Actividad> crearActividad(@RequestBody Actividad actividad) {
        if (actividad.getUsuario() == null || !usuarioRepository.existsById(actividad.getUsuario().getId())) {
            return ResponseEntity.badRequest().build();
        }
        Actividad nuevaActividad = actividadRepository.save(actividad);
        return ResponseEntity.ok(nuevaActividad);
    }

    @GetMapping
    public List<Actividad> listarActividades() {
        return actividadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> obtenerActividadPorId(@PathVariable int id) {
        Actividad actividad = actividadRepository.findById(id).orElse(null);
        if (actividad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actividad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actividad> actualizarActividad(@PathVariable int id, @RequestBody Actividad detallesActividad) {
        Actividad actividad = actividadRepository.findById(id).orElse(null);
        if (actividad == null) {
            return ResponseEntity.notFound().build();
        }

        actividad.setTitulo(detallesActividad.getTitulo());
        actividad.setDescripcion(detallesActividad.getDescripcion());
        actividad.setEstado(detallesActividad.getEstado());
        actividad.setPrioridad(detallesActividad.getPrioridad());

        Actividad actividadActualizada = actividadRepository.save(actividad);
        return ResponseEntity.ok(actividadActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarActividad(@PathVariable int id) {
        Actividad actividad = actividadRepository.findById(id).orElse(null);
        if (actividad == null) {
            return ResponseEntity.notFound().build();
        }

        actividadRepository.delete(actividad);
        return ResponseEntity.noContent().build();
    }
}