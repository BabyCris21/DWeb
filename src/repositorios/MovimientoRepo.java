package repositorios;

import database.Db;
import entidades.Movimiento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovimientoRepo {

    private Db db;

    public MovimientoRepo(){

        this.db = Db.getInstance();
    }

        public List<Movimiento> listarMovimientos() {
            String statement = "SELECT id, idusuariocuenta, idmovimientotipo, idmovimientocategoria, nombre, activo, fechaCreacion  FROM usuario_cuenta_movimiento;";
            List<Movimiento> movimientos = new ArrayList<>();
            try {
                PreparedStatement ps = db.conectar().prepareStatement(statement);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    int id = rs.getInt("id");
                    int idusuariocuenta = rs.getInt("idusuariocuenta");
                    int idmovimientotipo = rs.getInt("idmovimientotipo");
                    int idmovimientocategoria = rs.getInt("idmovimientocategoria");
                    String nombre = rs.getString("nombre");
                    int activo = rs.getInt("activo");
                    String fechaCreacion = rs.getString("fechaCreacion");
                    movimientos.add(new Movimiento(id, idusuariocuenta, idmovimientotipo, idmovimientocategoria, nombre, activo,fechaCreacion));
                }
                rs.close();
                ps.close();
            } catch (SQLException e) {
                Logger.getLogger(MovimientoRepo.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                db.desconectar();
            }
            return movimientos;
    }
}
