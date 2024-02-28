package com.trabajoFinal.trabajoFinal.repository;

import com.trabajoFinal.trabajoFinal.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}


