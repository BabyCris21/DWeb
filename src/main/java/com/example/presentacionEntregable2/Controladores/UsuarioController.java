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
    @GetMapping("/")
    public String home(Model model) {
        var usuarios = _usuarioRepositorio.Listar();
        model.addAttribute("usuarios", usuarios);
        return "usuario.lista";
    }
}
