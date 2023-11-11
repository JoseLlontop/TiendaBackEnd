package com.trabajoFinal.trabajoFinal.repository;

import com.trabajoFinal.trabajoFinal.models.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;

//DAO: abstrae la capa de acceso a datos de la aplicación para que el resto
//del código no necesite conocer los detalles de como interactúa con la base de datos
@Repository
public interface ProductoDao {

    //Operaciones que simplifican la interacción con la BD
    List<Producto> getProductos();

    Producto getProductoById(int id);

    void eliminar(int id);

    void registrar(Producto producto);
}
