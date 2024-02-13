package com.trabajoFinal.trabajoFinal.repository;

import com.trabajoFinal.trabajoFinal.models.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {
}
