package com.example.presentacionEntregable2.Repositorios;

import com.example.presentacionEntregable2.Entidades.Usuario;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UsuarioRepositorio implements IRepositorio<Usuario> {
    @Override
    public List<Usuario> Listar() {
        String statement = "SELECT id, correo, nombres, apellidos, telefono, activo, fechaCreacion  FROM Usuario;";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            PreparedStatement ps = DatabaseConnection.getInstancia().prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return usuarios;
    }
    @Override
    public Usuario ObtenerPorId(int id) {
        return null;
    }

    @Override
    public void Crear(Usuario objeto) {

    }

    @Override
    public void Eliminar(Usuario objeto) {

    }

    @Override
    public void Actualizar(Usuario objeto) {

    }
}
