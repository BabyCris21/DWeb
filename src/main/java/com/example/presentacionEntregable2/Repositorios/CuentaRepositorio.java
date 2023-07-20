package com.example.presentacionEntregable2.Repositorios;

import com.example.presentacionEntregable2.Entidades.Categoria;
import com.example.presentacionEntregable2.Entidades.Cuenta;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CuentaRepositorio implements IRepositorio<Cuenta> {

    private final Connection db;
    public CuentaRepositorio(){
        try {
            this.db = DatabaseConnection.getInstancia();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cuenta> Listar() {
        String statement = "SELECT id, idusuario, nombre, activo, descripcion, fechaCreacion FROM usuario_cuenta_categoria where activo=1;";
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            PreparedStatement ps = db.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idusuario = rs.getInt("idusuario");
                int activo = rs.getInt("activo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String date = rs.getString("fechaCreacion");
                cuentas.add(new Cuenta(id, idusuario, nombre, descripcion, activo, date));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return cuentas;
    }

    @Override
    public Cuenta ObtenerPorId(int id) {
        Cuenta cuentas = null;
        String procedure = "SELECT id, idusuario, nombre, activo, fechaCreacion FROM usuario_movimiento_categoria WHERE id = ? and activo=1;";
        try {
            PreparedStatement ps = db.prepareStatement(procedure);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idcue = rs.getInt("idcuenta");
                int idusuario = rs.getInt("idusuario");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int activo = rs.getInt("activo");
                String fechaCreacion = rs.getString("fechaCreacion");
                cuentas = new Cuenta(idcue, idusuario, nombre, descripcion,activo, fechaCreacion);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(CuentaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return cuentas;
    }

    @Override
    public void Crear(Cuenta objeto) {

        String procedure = "INSERT INTO usuario_cuenta_categoria (id, nombre) VALUES (?,?);";

        try{
            PreparedStatement cs=db.prepareStatement(procedure);
            cs.setInt(1,objeto.getId());
            cs.setString(2, objeto.getMombre());
            cs.execute();
            cs.close();
        }
        catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
    }

    @Override
    public Cuenta Eliminar(Cuenta objeto) {
        String procedure = "DELETE FROM usuario_cuenta_categoria WHERE id = ?;";

        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setInt(1, objeto.getId());
            cs.executeUpdate();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }

        return objeto;
    }


    @Override
    public void Actualizar(Cuenta objeto) {
        String procedure = "UPDATE usuario_cuenta_categoria SET nombre = ? WHERE id = ?;";

        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setString(1, objeto.getMombre());
            cs.setInt(2, objeto.getId());
            cs.executeUpdate();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
    }
}