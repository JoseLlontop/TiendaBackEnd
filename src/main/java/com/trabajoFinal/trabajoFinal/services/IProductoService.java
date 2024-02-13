package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> getAll();

    Producto getById(int id);

    void remove(int id);

    void save(Producto cobranza);

    void update(int id, Producto producto);
}
