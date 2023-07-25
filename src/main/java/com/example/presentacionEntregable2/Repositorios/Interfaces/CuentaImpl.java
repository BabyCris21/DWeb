package com.example.presentacionEntregable2.Repositorios.Interfaces;

import com.example.presentacionEntregable2.Entidades.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CuentaImpl implements ICuenta {

        @Autowired

        private EntityMaxnager em;

        @Override
        @Transactional(readOnly = true)
        public List<Cuenta> ListarTodos() {

            return em.createQuery("from Cliente").getResultList();

        }

        @Override
        @Transactional
        public Cuenta ListarPorId(Long Id) {

            return em.find(Cuenta.class,Id);
        }

        @Override
        @Transactional
        public void Guardar(Cuenta cuenta) {

            if (cuenta.getId()!= null && cuenta.getId() > 0){
                em.merge(cuenta);
            }
            else{
                em.persist(cuenta);
            }
        }

        @Override
        @Transactional
        public void Eliminar(Long id) {

            em.remove(ListarPorId(id));

        }
    @Override
    @Transactional
    public void Guardar(Cuenta cuenta) {

        if (cuenta.getId() != null && cuenta.getId() > 0){
            em.merge(cuenta);
        }
        else{
            em.persist(cuenta);
        }
    }

    @Override
    @Transactional
    public void Eliminar(Long id) {

        em.remove(ListarPorId(id));

    }


}





