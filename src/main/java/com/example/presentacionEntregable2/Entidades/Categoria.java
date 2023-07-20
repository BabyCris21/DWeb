package com.example.presentacionEntregable2.Entidades;



public class Categoria {
    int Id;
    int IdUsuario;
    int Activo;
    String Nombre;
    String fechaRegistro;

    public Categoria(int id, int idUsuario, int activo, String nombre, String fechaRegistro) {
        Id = id;
        IdUsuario = idUsuario;
        Activo = activo;
        Nombre = nombre;
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria(int idUsuario, String nombre) {
        IdUsuario = idUsuario;
        Nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int activo) {
        Activo = activo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFechaCreacion() {
        return fechaRegistro;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaRegistro = fechaCreacion;
    }
}