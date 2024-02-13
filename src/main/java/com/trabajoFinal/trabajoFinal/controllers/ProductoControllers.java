package com.trabajoFinal.trabajoFinal.controllers;

import com.trabajoFinal.trabajoFinal.models.Producto;
import com.trabajoFinal.trabajoFinal.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indicamos que esta va a ser un controlador
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoControllers {

    @Autowired
    private IProductoService service;

    @GetMapping("/api/productos")
    public List<Producto> getAll(){
        return service.getAll();
    }

    @GetMapping("/api/productos/{id}")
    public Producto getById(@PathVariable int id){
        return service.getById(id);
    }

    @DeleteMapping("/api/productos/{id}")
    public void remove(@PathVariable int id) {
        service.remove(id);
    }

    @PostMapping("/api/productos")
    public void save(@RequestBody Producto producto){
        service.save(producto);
    }

    @PutMapping("/api/productos/{id}")
    public void update(@PathVariable int id, @RequestBody Producto updateProducto) {
        service.update(id, updateProducto);
    }

}
