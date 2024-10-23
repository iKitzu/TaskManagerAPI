package com.actividades.api.registro_actividades.repository;

import com.actividades.api.registro_actividades.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
