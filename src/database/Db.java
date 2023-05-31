package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db {

    private final String URL;
    private final String BD;
    private final String USER;
    private final char[] PASSWORD;
    public Connection cnx;
    private static volatile Db selfinstance;
    private Db() {
        this.URL = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;database=";
        this.BD = "proyecto_dwi;";
        this.USER = "JDBC";
        this.PASSWORD = "123".toCharArray();
        this.cnx = null;
    }

    public Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.cnx = DriverManager.getConnection(URL + BD, USER, String.valueOf(PASSWORD));
        }catch (ClassNotFoundException e){
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, e);
        }catch (SQLException e){
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, e);
            clearInstance();
        }
        return this.cnx;
    }

    synchronized public static void clearInstance(){
        selfinstance = null;
    }

    public void desconectar() {
        try {
            this.cnx.close();
        } catch (SQLException e){
        }
    }
    //"Constructor"
    public static Db getInstance(){
        Db result = selfinstance;
        if (result != null) {
            return result;
        }
        synchronized(Db.class){
            if(selfinstance == null){
                selfinstance = new Db();
            }
            return selfinstance;
        }
    }
}
