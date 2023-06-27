package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Entidades.Categoria;
import com.example.presentacionEntregable2.Repositorios.CategoriaRepositorio;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaController{
    private IRepositorio<Categoria> _repositorio;

    public CategoriaController(){
        _repositorio = new CategoriaRepositorio();
    }

    @GetMapping("/categorias")
    public String listar(Model model){
        var categorias = _repositorio.Listar();
        model.addAttribute("categorias", categorias);
        return "categoria.lista";
    }

    @GetMapping("/crearCategoria")
    public String crear(Model model){
        _repositorio.Crear(new Categoria(1, "Exposicion"));
        var categorias = _repositorio.Listar();
        model.addAttribute("categorias", categorias);
        return "categoria.lista";
    }
}
