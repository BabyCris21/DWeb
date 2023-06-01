package com.example.presentacionEntregable2.Repositorios;

import com.example.presentacionEntregable2.Entidades.Categoria;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaRepositorio implements IRepositorio<Categoria> {

    private Connection db;
    public CategoriaRepositorio(){
        try {
            this.db = DatabaseConnection.getInstancia();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Categoria> Listar() {
        String statement = "SELECT id, idusuario, nombre, activo, fechaCreacion FROM usuario_movimiento_categoria;";
        List<Categoria> categorias = new ArrayList<>();
        try {
            PreparedStatement ps = db.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
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
         cliente = null;
        String statement = "SELECT , nombre, telefono, direccion, dni FROM  WHERE id_cliente = ?;";
        try {
            PreparedStatement ps = sql.conectar().prepareStatement(statement);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String dni = rs.getString("dni");
                cliente = new Cliente(idCliente, nombre, telefono, direccion, dni);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            sql.desconectar();
        }
        System.out.println(cliente);
        return cliente;


        return null;
    }

    @Override
    public void Crear(Categoria objeto) {

            String procedure = "INSERT INTO usuario_movimiento_categoria (id, idusuario, nombre, activo, fechaCreacion) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setInt(1, objeto.getId());
            cs.setInt(2, objeto.getIdUsuario());
            cs.setString(3, objeto.getNombre());
            cs.setInt(4, objeto.getActivo());
            cs.setString(5, objeto.getFechaCreacion());
            ResultSet rs = cs.executeQuery();
            rs.close();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();

    }

    @Override
    public void Eliminar(Categoria objeto) {

        }

    }

    @Override
    public void Actualizar(Categoria objeto) {

    }
}
