package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Proveedor;
import com.trabajoFinal.trabajoFinal.models.Usuario;
import com.trabajoFinal.trabajoFinal.repository.ProveedorRepository;
import com.trabajoFinal.trabajoFinal.repository.UsuarioRepository;
import com.trabajoFinal.trabajoFinal.services.Interface.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private ProveedorRepository repository;

    @Autowired
    private UsuarioService serviceUsuario;

    @Override
    public List<Proveedor> getAll() {
        return (List<Proveedor>) repository.findAll();
    }

    @Override
    public void save(Proveedor proveedor) {
        Usuario usuario = serviceUsuario.save(proveedor.getUsuario());
        proveedor.setUsuario_ID(usuario.getID());
        proveedor.setUsuario(usuario);

        repository.save(proveedor);
    }
}