package com.example.presentacionEntregable2.Repositorios;

import com.example.presentacionEntregable2.Entidades.Usuario;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioRepositorio implements IRepositorio<Usuario> {

    private Connection db;
    public UsuarioRepositorio(){
        try {
            this.db = DatabaseConnection.getInstancia();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Usuario> Listar() {
        String statement = "SELECT id, correo, nombres, apellidos, telefono, activo, fechaCreacion  FROM usuario;";
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = db.prepareStatement(statement);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String correo = rs.getString("correo");
                String nombre = rs.getString("nombres");
                String apellido = rs.getString("apellidos");
                String telefono = rs.getString("telefono");
                int activo = rs.getInt("activo");
                String date = rs.getString("fechaCreacion");
                usuarios.add(new Usuario(id, activo, correo, nombre, apellido, telefono, date));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(UsuarioRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            rs = null;
            ps = null;
        }
        return usuarios;
    }
    @Override
    public Usuario ObtenerPorId(int id) {

        Usuario usuario = null;
        String procedure = "SELECT id, correo, nombres, apellidos, telefono, activo, fechaCreacion  FROM usuario WHERE id = ?;";
        try {
            PreparedStatement ps = db.prepareStatement(procedure);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idcat = rs.getInt("id");
                String correo = rs.getNString("correo");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String telefono = rs.getNString("telefono");
                int activo = rs.getInt("activo");
                String fechaCreacion = rs.getString("fechaCreacion");
                usuario = new Usuario(idcat, activo, correo, nombres, apellidos, telefono, fechaCreacion );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(UsuarioRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return usuario;
    }

    @Override
    public void Crear(Usuario objeto) {
        String procedure = "INSERT INTO usuario (correo, nombres, apellidos, telefono) VALUES (?,?,?,?);";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setString(1, objeto.getCorreo());
            cs.setString(2, objeto.getNombre());
            cs.setString(3, objeto.getApellido());
            cs.setString(4, objeto.getTelefono());
            ResultSet rs = cs.executeQuery();
            rs.close();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(UsuarioRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
    }

    @Override
    public Usuario Eliminar(Usuario objeto) {
        String procedure = "DELETE FROM usuario WHERE id=?;";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setInt(1, objeto.getId());
            ResultSet rs = cs.executeQuery();
            rs.close();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(UsuarioRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return objeto;
    }

    @Override
    public void Actualizar(Usuario objeto) {
        /*String procedure = "UPDATE usuario Set correo   WHERE id = ?";
>>>>>>> 818c8e3330642083de68481d50cfc722f384ac6b
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setInt(1, objeto.getId());
            cs.setString(2, objeto.getCorreo());
            cs.setString(3, objeto.getNombre());
            cs.setString(4, objeto.getApellido());
            cs.setString(5, objeto.getTelefono());
            cs.setInt(6, objeto.getActivo());
            cs.setString(7, objeto.getFechaCreacion());
            ResultSet rs = cs.executeQuery();
            rs.close();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(UsuarioRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
<<<<<<< HEAD
        }
=======
        }*/
    }
}