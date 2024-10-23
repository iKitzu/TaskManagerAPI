package com.actividades.api.registro_actividades.repository;

import com.actividades.api.registro_actividades.model.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {
}