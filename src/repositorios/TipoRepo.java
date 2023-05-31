package repositorios;

import database.Db;
import entidades.Tipo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoRepo {

    private Db db;

    public TipoRepo(){
        this.db = Db.getInstance();
    }

    public List<Tipo> listarTipos() {
        String statement = "SELECT id, nombre, activo FROM usuario_movimiento_tipo;";
        List<Tipo> tipos = new ArrayList<>();
        try {
            PreparedStatement ps = db.conectar().prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int activo = rs.getInt("activo");
                tipos.add(new Tipo(id, nombre, activo));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(TipoRepo.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            db.desconectar();
        }
        return tipos;
    }
}



