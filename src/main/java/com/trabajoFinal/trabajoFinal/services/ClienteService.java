package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Cliente;
import com.trabajoFinal.trabajoFinal.models.Usuario;
import com.trabajoFinal.trabajoFinal.repository.ClienteRepository;
import com.trabajoFinal.trabajoFinal.services.Interface.IClienteService;
import com.trabajoFinal.trabajoFinal.services.Interface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private IUsuarioService serviceUsuario;

    @Override
    public List<Cliente> getAll() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        Usuario usuario = serviceUsuario.save(cliente.getUsuario());
        cliente.setUsuario_ID(usuario.getID());
        cliente.setUsuario(usuario);

        repository.save(cliente);
    }
}
