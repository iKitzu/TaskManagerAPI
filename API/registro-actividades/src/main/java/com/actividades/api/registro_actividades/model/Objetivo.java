package com.actividades.api.registro_actividades.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "objetivos")
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_fk")
    private Usuario usuario;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(name = "fecha_de_vencimiento")
    private LocalDateTime fechaDeVencimiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    @CreationTimestamp
    @Column(name = "fecha_de_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaDeCreacion;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(LocalDateTime fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public enum Estado {
        ACTIVO, PENDIENTE, SUSPENDIDO
    }
}
