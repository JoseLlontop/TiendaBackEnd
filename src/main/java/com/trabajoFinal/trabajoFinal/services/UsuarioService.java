package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Usuario;
import com.trabajoFinal.trabajoFinal.repository.UsuarioRepository;
import com.trabajoFinal.trabajoFinal.services.Interface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository repository;


    @Override
    public Usuario save(Usuario usuario) {
        repository.save(usuario);

        return usuario;
    }
}
