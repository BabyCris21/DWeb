import entidades.Usuario;
import repositorios.UsuarioRepo;

import java.sql.*;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        UsuarioRepo a = new UsuarioRepo();

        a.listarClientes().forEach(System.out::println);

    }
}
