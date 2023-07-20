package com.example.presentacionEntregable2.Repositorios;

import com.example.presentacionEntregable2.Entidades.Categoria;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Util.DatabaseConnection;
import com.microsoft.sqlserver.jdbc.ISQLServerStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaRepositorio implements IRepositorio<Categoria> {
    private final Connection db;
    public CategoriaRepositorio(){
        try {
            this.db = DatabaseConnection.getInstancia();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Categoria> Listar() {
        String statement = "SELECT id, idusuario, nombre, activo, fechaCreacion FROM usuario_movimiento_categoria where activo=1;";
        List<Categoria> categorias = new ArrayList<>();
        try {
            PreparedStatement ps = db.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idusuario = rs.getInt("idusuario");
                int activo = rs.getInt("activo");
                String nombre = rs.getString("nombre");
                String date = rs.getString("fechaCreacion");
                categorias.add(new Categoria(id, idusuario, activo, nombre, date));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return categorias;

    }

    @Override
    public Categoria ObtenerPorId(int id) {
        Categoria categoria = null;
        String procedure = "SELECT id, idusuario, nombre, activo, fechaCreacion FROM usuario_movimiento_categoria WHERE id = ? and activo=1;";
        try {
            PreparedStatement ps = db.prepareStatement(procedure);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idcat = rs.getInt("id");
                int idusuario = rs.getInt("idusuario");
                String nombre = rs.getString("nombre");
                int activo = rs.getInt("activo");
                String fechaCreacion = rs.getString("fechaCreacion");
                categoria = new Categoria(idcat, idusuario, activo, nombre, fechaCreacion);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return categoria;
    }
    @Override
    public void Crear(Categoria objeto) {
            String procedure = "INSERT INTO usuario_movimiento_categoria (idusuario, nombre) VALUES (?,?);";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setInt(1, objeto.getIdUsuario());
            cs.setString(2, objeto.getNombre());
            cs.execute();
            cs.close();
            } catch (SQLException e) {
                Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                DatabaseConnection.cerrarConexion();
            }
    }

    @Override
    public Categoria Eliminar(Categoria objeto) {
        String procedure = "UPDATE usuario_movimiento_categoria SET activo=0 WHERE id=?;";
        try (PreparedStatement cs = db.prepareStatement(procedure)) {
            cs.setInt(1, objeto.getId());
            cs.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        }
        return objeto;
    }

    @Override
    public void Actualizar(Categoria objeto) {
            String procedure = "UPDATE usuario_movimiento_categoria Set nombre=?  WHERE id = ?";
            try {
                PreparedStatement cs = db.prepareStatement(procedure);
                cs.setString(1, objeto.getNombre());
                cs.setInt(2, objeto.getId());
                cs.execute();
                cs.close();
            } catch (SQLException e) {
                Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                DatabaseConnection.cerrarConexion();
            }
    }
}