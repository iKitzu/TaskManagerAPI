package com.actividades.api.registro_actividades.service;

import com.actividades.api.registro_actividades.model.Usuario;
import com.actividades.api.registro_actividades.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuarioExistente, Usuario detallesUsuario) {
        usuarioExistente.setNombreUsuario(detallesUsuario.getNombreUsuario());
        usuarioExistente.setEmail(detallesUsuario.getEmail());
        usuarioExistente.setContrasenaHash(detallesUsuario.getContrasenaHash());
        return usuarioRepository.save(usuarioExistente);
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}