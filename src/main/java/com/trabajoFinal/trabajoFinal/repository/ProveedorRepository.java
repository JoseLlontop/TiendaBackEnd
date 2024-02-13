package com.trabajoFinal.trabajoFinal.repository;

import com.trabajoFinal.trabajoFinal.models.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Integer> {
}
