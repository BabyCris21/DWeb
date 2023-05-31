package repositorios;

import database.Db;
import entidades.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioRepo {

    private Db db;

        public UsuarioRepo(){
            this.db = Db.getInstance();
        }

    public List<Usuario> listarClientes() {
        String statement = "SELECT id, correo, nombres, apellidos, telefono, activo, fechaCreacion  FROM Usuario;";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            PreparedStatement ps = db.conectar().prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
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
            Logger.getLogger(UsuarioRepo.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            db.desconectar();
        }
        return usuarios;
    }
}
