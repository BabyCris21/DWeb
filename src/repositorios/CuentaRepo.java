package repositorios;

import database.Db;
import entidades.Cuenta;
import entidades.Movimiento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CuentaRepo {

    private Db db;

    public CuentaRepo(){

        this.db = Db.getInstance();
    }

    public List<Cuenta> listarCuentas() {
        String statement = "SELECT id, idusuario, nombre, descripcion, activo, fechaCreacion  FROM usuario_cuenta;";
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            PreparedStatement ps = db.conectar().prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                int idusuario = rs.getInt("idusuariocuenta");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int activo = rs.getInt("activo");
                String fechaCreacion = rs.getString("fechaCreacion");
                cuentas.add(new Cuenta(id, idusuario, nombre, descripcion,activo,fechaCreacion));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(CuentaRepo.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            db.desconectar();
        }
        return cuentas;
    }

}
