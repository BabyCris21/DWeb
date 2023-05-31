package entidades;

import java.util.Date;

public class Cuenta {
    int Id;
    int IdUsuario;
    int Activo;
    String Nombre;
    String Descripcion;
    Date fecha_creacion;

    public Cuenta(int id, int idUsuario, int activo, String nombre, String descripcion, Date fecha_creacion) {
        Id = id;
        IdUsuario = idUsuario;
        Activo = activo;
        Nombre = nombre;
        Descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
