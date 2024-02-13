package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Proveedor;

import java.util.List;

public interface IProveedorService {

    List<Proveedor> getAll();

    void save(Proveedor proveedor);
}
