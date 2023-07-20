package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Entidades.Cuenta;
import com.example.presentacionEntregable2.Repositorios.CuentaRepositorio;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CuentaController{
    private IRepositorio<Cuenta> _repositorio;

    public CuentaController(){
        _repositorio = new CuentaRepositorio();
    }

    @GetMapping("/cuentas")
    public String listar(Model model){
        var categorias = _repositorio.Listar();
        model.addAttribute("cuentas","1");
        return "cuenta.lista";
    }

    @GetMapping("/crearCuentas")
    public String crear(Model model){
        _repositorio.Crear(new Cuenta(1, 234,"Soles","Cuenta soles",2,"21/12/2015"));
        var cuentas = _repositorio.Listar();
        model.addAttribute("cuentas", cuentas);
        return "cuentas.lista";
    }

    @GetMapping("/eliminarCuenta")
    public String eliminar(@RequestParam int id, Model model) {
        Cuenta cuenta = _repositorio.ObtenerPorId(id);

        _repositorio.Eliminar(cuenta);

        return "redirect:/cuentas";
    }

    @GetMapping("/editarCuenta")
    public String editar(@RequestParam int id, Model model) {
        Cuenta cuenta = _repositorio.ObtenerPorId(id);
        model.addAttribute("cuenta", cuenta);
        return "cuenta.editar";
    }

    @PostMapping("/actualizarCuenta")
    public String actualizar(@ModelAttribute Cuenta cuenta, Model model) {
        _repositorio.Actualizar(cuenta);
        return "redirect:/cuentas";
    }

}
