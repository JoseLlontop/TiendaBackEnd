package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Venta;
import com.trabajoFinal.trabajoFinal.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository repository;


    @Override
    public void save(Venta venta) {
        repository.save(venta);
    }
}
