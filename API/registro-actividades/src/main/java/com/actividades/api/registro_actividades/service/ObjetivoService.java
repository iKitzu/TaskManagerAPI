package com.actividades.api.registro_actividades.service;

import com.actividades.api.registro_actividades.model.Objetivo;
import com.actividades.api.registro_actividades.repository.ObjetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetivoService {

    @Autowired
    private ObjetivoRepository objetivoRepository;

    public List<Objetivo> listarObjetivos() {
        return objetivoRepository.findAll();
    }

    public Optional<Objetivo> obtenerObjetivoPorId(int id) {
        return objetivoRepository.findById(id);
    }

    public Objetivo crearObjetivo(Objetivo objetivo) {
        return objetivoRepository.save(objetivo);
    }

    public Objetivo actualizarObjetivo(Objetivo objetivoExistente, Objetivo nuevoObjetivo) {
        objetivoExistente.setTitle(nuevoObjetivo.getTitle());
        objetivoExistente.setDescription(nuevoObjetivo.getDescription());
        objetivoExistente.setEstado(nuevoObjetivo.getEstado());
        objetivoExistente.setFechaDeVencimiento(nuevoObjetivo.getFechaDeVencimiento());
        return objetivoRepository.save(objetivoExistente);
    }

    public void eliminarObjetivo(int id) {
        objetivoRepository.deleteById(id);
    }
}