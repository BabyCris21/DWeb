package repositorios;

import database.Db;
import entidades.Categoria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaRepo{
    private Db db;
    public CategoriaRepo(){
        this.db = Db.getInstance();
    }

    public List<Categoria> listarCategoria() {
        String statement = "SELECT id, idusuario, nombre, activo, fechaCreacion FROM usuario_movimiento_categoria;";
        List<Categoria> categorias = new ArrayList<>();
        try {
            PreparedStatement ps = db.conectar().prepareStatement(statement);
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
            Logger.getLogger(CategoriaRepo.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            db.desconectar();
        }
        return categorias;
    }




}
