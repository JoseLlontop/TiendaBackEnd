package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Producto;
import com.trabajoFinal.trabajoFinal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> getAll() {
        return (List<Producto>) repository.findAll();
    }

    @Override
    public Producto getById(int id) {
        return (Producto) repository.findById(id).get();
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }

    @Override
    public void save(Producto producto) {
        repository.save(producto);
    }

    @Override
    public void update(int id, Producto updateProducto) {
        Producto existeProducto = repository.findById(id).orElse(null);

        if (existeProducto != null) {
            // Actualizo los campos del producto existente
            existeProducto.setDescripcion(updateProducto.getDescripcion());
            existeProducto.setImagen(updateProducto.getImagen());
            existeProducto.setNombre(updateProducto.getNombre());
            existeProducto.setPrecio(updateProducto.getPrecio());

            repository.save(existeProducto);
        }
    }
}

