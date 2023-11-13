package com.trabajoFinal.trabajoFinal.service;

import com.trabajoFinal.trabajoFinal.models.Producto;
import com.trabajoFinal.trabajoFinal.repository.ProductoDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

//Referencia a que esta clase se va a usar para la conexión a la BD
@Repository
@Transactional //Agrega funcionalidad a la clase de poder armar las consultas SQL a la BD
public class ProductoService implements ProductoDao {

    //EntityManager se encarga de administrar la comunicación con la BD,
    //incluyendo operaciones como guardar, actualizar, eliminar y consultar datos en la BD.
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Producto> getProductos() {
        //Es una consulta que se está haciendo sobre Hibernate
        //No se está haciendo referencia a una tabla sino a una clase
        String query = "FROM Producto";
        //El encargado de administrar la BD ejecuta esa consulta y el resultado lo transformamos en una lista:
        return entityManager.createQuery(query, Producto.class).getResultList();

    }

    @Override
    public Producto getProductoById(int id) {
        return entityManager.find(Producto.class, id);
    }

    @Override
    public void eliminar(int id) {
        //El encargado de la BD lo va a buscar y luego lo va a eliminar:
        Producto producto = entityManager.find(Producto.class, id);
        entityManager.remove(producto);
    }

    @Override
    public void registrar(Producto producto) {
        //merge: sincroniza un objeto si el objeto no existe en la base de datos,
        //se creará uno nuevo con los valores que se le pasen por parametro
        entityManager.merge(producto);
    }

    @Override
    public void actualizar(int id, Producto producto) {

        Producto productoActualizar = entityManager.find(Producto.class, id);

        //Actualizo sus propiedades con los nuevos valores
        productoActualizar.setNombre(productoActualizar.getNombre());
        productoActualizar.setDescripcion(productoActualizar.getDescripcion());
        productoActualizar.setPrecio(productoActualizar.getPrecio());
        productoActualizar.setImagen(productoActualizar.getImagen());

        entityManager.merge(productoActualizar);
    }
}

