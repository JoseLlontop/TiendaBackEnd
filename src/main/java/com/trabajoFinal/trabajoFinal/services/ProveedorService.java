package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Cliente;
import com.trabajoFinal.trabajoFinal.models.Proveedor;
import com.trabajoFinal.trabajoFinal.repository.ClienteRepository;
import com.trabajoFinal.trabajoFinal.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private ProveedorRepository repository;

    @Override
    public List<Proveedor> getAll() {
        return (List<Proveedor>) repository.findAll();
    }

    @Override
    public void save(Proveedor proveedor) {
        repository.save(proveedor);
    }
}