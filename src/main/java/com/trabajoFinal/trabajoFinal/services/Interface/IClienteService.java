package com.trabajoFinal.trabajoFinal.services.Interface;

import com.trabajoFinal.trabajoFinal.models.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> getAll();

    void save(Cliente cliente);
}
