package com.example.presentacionEntregable2.Entidades;

import java.util.Date;

public class Cuenta {
    int id;
    int idUsuario;
    String nombre;
    String descripcion;
    int activo;
    String fechaCreacion;

    public Cuenta(int id, int idUsuario, String nombre, String descripcion, int activo, String fechaCreacion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMombre() {
        return nombre;
    }

    public void setMombre(String mombre) {
        this.nombre = mombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}