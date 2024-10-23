package com.actividades.api.registro_actividades.service;

import com.actividades.api.registro_actividades.model.Actividad;
import com.actividades.api.registro_actividades.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    public List<Actividad> listarActividades() {
        return actividadRepository.findAll();
    }

    public Optional<Actividad> obtenerActividadPorId(int id) {
        return actividadRepository.findById(id);
    }

    public Actividad crearActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public Actividad actualizarActividad(Actividad actividadExistente, Actividad nuevaActividad) {
        actividadExistente.setTitulo(nuevaActividad.getTitulo());
        actividadExistente.setDescripcion(nuevaActividad.getDescripcion());
        actividadExistente.setEstado(nuevaActividad.getEstado());
        actividadExistente.setPrioridad(nuevaActividad.getPrioridad());
        return actividadRepository.save(actividadExistente);
    }

    public void eliminarActividad(int id) {
        actividadRepository.deleteById(id);
    }
}