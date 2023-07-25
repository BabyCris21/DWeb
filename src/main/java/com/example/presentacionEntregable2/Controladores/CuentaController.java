package com.example.presentacionEntregable2.Controladores;

import com.example.presentacionEntregable2.Repositorios.Interfaces.CuentaImpl;
import com.example.presentacionEntregable2.Repositorios.Interfaces.ICuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/cuenta")
@Controller


public class CuentaController {

        @Autowired
        private ICuenta CuentaImpl;

        @GetMapping("/listar")
        public String listarCuenta(Model model) {
            model.addAttribute("titulo", "Cuentas");
            model.addAttribute("cuentas", CuentaImpl.ListarTodos());

            return "listarCuenta";
        }

    }

