package entidades;

import java.util.Date;
public class Categoria {
    int Id;
    int IdUsuario;
    int Activo;
    String Nombre;
    Date fechaRegistro;
    public Categoria(int id, int idUsuario, int activo, String nombre, Date fechaRegistro) {
        Id = id;
        IdUsuario = idUsuario;
        Activo = activo;
        Nombre = nombre;
        this.fechaRegistro = fechaRegistro;
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
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;}
}
