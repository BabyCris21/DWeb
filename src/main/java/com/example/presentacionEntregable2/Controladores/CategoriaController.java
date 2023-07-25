package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Entidades.Categoria;
import com.example.presentacionEntregable2.Repositorios.CategoriaRepositorio;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        _repositorio.Crear(new Categoria(1, 2,1,"A","2003-11-21"));
        var categorias = _repositorio.Listar();
        model.addAttribute("categorias", categorias);
        return "categoria.lista";
    }

    @PostMapping("/eliminarCategoria")
    public String eliminar(@RequestParam int id, Model model) {
        Categoria categoria = _repositorio.ObtenerPorId(id);
        if (categoria != null) {
            _repositorio.Eliminar(categoria);
        }
        return "redirect:/categorias";
    }

    @GetMapping("/editarCategoria")
    public String editar(@RequestParam int id, Model model) {
        Categoria categoria = _repositorio.ObtenerPorId(id);
        model.addAttribute("categoria", categoria);
        return "categoria.editar";
    }

    @PostMapping("/actualizarCategoria")
    public String actualizar(@ModelAttribute Categoria categoria, Model model) {
        _repositorio.Actualizar(categoria);
        return "redirect:/categorias";
    }
}
