package com.actividades.api.registro_actividades.controller;

import com.actividades.api.registro_actividades.model.Objetivo;
import com.actividades.api.registro_actividades.repository.ObjetivoRepository;
import com.actividades.api.registro_actividades.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Objetivo> crearObjetivo(@RequestBody Objetivo objetivo) {
        if (objetivo.getUsuario() == null || !usuarioRepository.existsById(objetivo.getUsuario().getId())) {
            return ResponseEntity.badRequest().build();
        }
        Objetivo nuevoObjetivo = objetivoRepository.save(objetivo);
        return ResponseEntity.ok(nuevoObjetivo);
    }

    @GetMapping
    public List<Objetivo> listarObjetivos() {
        return objetivoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Objetivo> obtenerObjetivoPorId(@PathVariable int id) {
        Objetivo objetivo = objetivoRepository.findById(id).orElse(null);
        if (objetivo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objetivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Objetivo> actualizarObjetivo(@PathVariable int id, @RequestBody Objetivo detallesObjetivo) {
        Objetivo objetivo = objetivoRepository.findById(id).orElse(null);
        if (objetivo == null) {
            return ResponseEntity.notFound().build();
        }

        objetivo.setTitle(detallesObjetivo.getTitle());
        objetivo.setDescription(detallesObjetivo.getDescription());
        objetivo.setEstado(detallesObjetivo.getEstado());
        objetivo.setFechaDeVencimiento(detallesObjetivo.getFechaDeVencimiento());

        Objetivo objetivoActualizado = objetivoRepository.save(objetivo);
        return ResponseEntity.ok(objetivoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarObjetivo(@PathVariable int id) {
        Objetivo objetivo = objetivoRepository.findById(id).orElse(null);
        if (objetivo == null) {
            return ResponseEntity.notFound().build();
        }

        objetivoRepository.delete(objetivo);
        return ResponseEntity.noContent().build();
    }
}