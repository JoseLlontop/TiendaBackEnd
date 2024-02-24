package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Venta;
import com.trabajoFinal.trabajoFinal.repository.VentaRepository;
import com.trabajoFinal.trabajoFinal.services.Interface.IClienteService;
import com.trabajoFinal.trabajoFinal.services.Interface.IUsuarioService;
import com.trabajoFinal.trabajoFinal.services.Interface.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository repository;

    @Override
    public void save(Venta venta) {
        repository.save(venta);
    }
}
