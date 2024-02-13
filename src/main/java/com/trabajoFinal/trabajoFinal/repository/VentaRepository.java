package com.trabajoFinal.trabajoFinal.repository;

import com.trabajoFinal.trabajoFinal.models.Venta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends CrudRepository<Venta, Integer> {
}
