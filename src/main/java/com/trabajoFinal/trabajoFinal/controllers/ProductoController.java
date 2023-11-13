package com.trabajoFinal.trabajoFinal.controllers;

import com.trabajoFinal.trabajoFinal.repository.ProductoDao;
import com.trabajoFinal.trabajoFinal.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indicamos que esta va a ser un controlador
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {

    @Autowired //La anotación automáticamente hace que la clase ProductoDaoImplement se cree un objeto y la guarda en productoDao (se está inyectando una instancia de una clase que implementa la interfaz)
    ProductoDao productoDao;

    //Indicamos la URL en la cual se va a retornar el contenido de la función
    @RequestMapping(value = "api/productos/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int id) {

        productoDao.eliminar(id);
    }

    @RequestMapping(value = "api/productos/{id}", method = RequestMethod.GET)
    public Producto getProductoById(@PathVariable int id) {

        return productoDao.getProductoById(id);
    }

    //Aclaramos que es por el método GET, pero por defecto tiene ese valor
    @RequestMapping(value = "api/productos", method = RequestMethod.GET)
    public List<Producto> getProductos() {

        return productoDao.getProductos();
    }

    @RequestMapping(value = "api/productos", method = RequestMethod.POST)
    //@RequestBody: convierte el JSON de producto a un objeto Producto
    public void registrarProducto(@RequestBody Producto producto) {

        productoDao.registrar(producto);
    }

    // Operación para actualizar un producto existente (PUT)
    @RequestMapping(value = "/api/productos/{id}", method = RequestMethod.PUT)
    public void actualizarProducto(@PathVariable int id, @RequestBody Producto producto) {

        productoDao.actualizar(id, producto);
    }

}
