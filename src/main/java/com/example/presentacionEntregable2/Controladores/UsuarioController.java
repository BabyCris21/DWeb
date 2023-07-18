package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Entidades.Usuario;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
    private IRepositorio<Usuario> _usuarioRepositorio;
    UsuarioController(){
        _usuarioRepositorio = new UsuarioRepositorio();
    }
    @GetMapping("/usuarios")
    public String listar(Model model) {
        var usuarios = _usuarioRepositorio.Listar();
        model.addAttribute("usuarios", usuarios);
        return "usuario.lista";
    }
    @GetMapping("/crearUsuario")
    public String crearUsuario(Model model) {
        _usuarioRepositorio.Crear(new Usuario("cc301220032@gmail.com","jesus","contreras","918521619"));
        var usuarios = _usuarioRepositorio.Listar();
        model.addAttribute("usuarios", usuarios);
        return "usuario.lista";
    }

    @GetMapping("/iniciosesion")
    public String obtenerPaginaInicioSesion(Model model){
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "index";
    }
}
