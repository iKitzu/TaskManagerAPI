package com.actividades.api.registro_actividades.repository;

import com.actividades.api.registro_actividades.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<Actividad, Integer> {
}