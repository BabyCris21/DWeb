package entidades;

import java.util.Date;
public class Movimiento {
    int Id;
    int IdCuenta;
    int IdMovimientoTipo;
    int IdMovimientoCategoria;
    int Activo;
    String Descripción;
    Float Monto;
    Date FechaCreacion;
    public Movimiento(int id, int idCuenta, int idMovimientoTipo, int idMovimientoCategoria, int activo, String descripción,
                      Float monto, Date fechaCreacion) {
        Id = id;
        IdCuenta = idCuenta;
        IdMovimientoTipo = idMovimientoTipo;
        IdMovimientoCategoria = idMovimientoCategoria;
        Activo = activo;
        Descripción = descripción;
        Monto = monto;
        FechaCreacion = fechaCreacion;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int getIdCuenta() {
        return IdCuenta;
    }
    public void setIdCuenta(int idCuenta) {
        IdCuenta = idCuenta;
    }
    public int getIdMovimientoTipo() {
        return IdMovimientoTipo;
    }
    public void setIdMovimientoTipo(int idMovimientoTipo) {
        IdMovimientoTipo = idMovimientoTipo;
    }
    public int getIdMovimientoCategoria() {
        return IdMovimientoCategoria;
    }
    public void setIdMovimientoCategoria(int idMovimientoCategoria) {
        IdMovimientoCategoria = idMovimientoCategoria;
    }
    public int getActivo() {
        return Activo;
    }
    public void setActivo(int activo) {
        Activo = activo;
    }
    public String getDescripción() {
        return Descripción;
    }
    public void setDescripción(String descripción) {
        Descripción = descripción;
    }
    public Float getMonto() {
        return Monto;
    }
    public void setMonto(Float monto) {
        Monto = monto;
    }
    public Date getFechaCreacion() {
        return FechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }
}