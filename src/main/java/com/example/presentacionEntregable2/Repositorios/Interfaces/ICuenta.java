package com.example.presentacionEntregable2.Repositorios.Interfaces;

import com.example.presentacionEntregable2.Entidades.Cuenta;

import java.util.List;

public interface ICuenta {
public List<Cuenta> ListarTodos();
public Cuenta ListarPorId(Long Id);
public void Guardar(Cuenta cuenta);
public void Eliminar(Long id);

        }
