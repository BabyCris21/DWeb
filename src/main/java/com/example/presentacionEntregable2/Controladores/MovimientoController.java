package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Entidades.Categoria;
import com.example.presentacionEntregable2.Entidades.Movimiento;
import com.example.presentacionEntregable2.Repositorios.CategoriaRepositorio;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Repositorios.MovimientoRepositorio;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class MovimientoController {
    private IRepositorio<Movimiento> _repositorio;

    public MovimientoController(){
        _repositorio = new MovimientoRepositorio();
    }

    @GetMapping("/movimientos")
    public String listar(Model model){
        var categorias = _repositorio.Listar();
        model.addAttribute("movimientos", categorias);
        return "movimiento.lista";
    }
}
