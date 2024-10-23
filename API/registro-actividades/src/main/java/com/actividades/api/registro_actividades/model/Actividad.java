package com.actividades.api.registro_actividades.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "activdades")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_fk", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String titulo;

    @Column
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridad prioridad;

    @CreationTimestamp
    @Column(name = "fecha_de_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaDeCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_de_actualizacion")
    private LocalDateTime fechaDeActualizacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public LocalDateTime getFechaDeActualizacion() {
        return fechaDeActualizacion;
    }

    public enum Estado {
        PENDIENTE, EN_PROCESO, COMPLETADA
    }

    public enum Prioridad {
        ALTA, MEDIA, BAJA
    }
}
