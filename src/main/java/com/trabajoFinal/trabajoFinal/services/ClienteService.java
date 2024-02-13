package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Cliente;
import com.trabajoFinal.trabajoFinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }
}
