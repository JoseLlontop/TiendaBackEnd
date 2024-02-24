package com.trabajoFinal.trabajoFinal.controllers;

import com.trabajoFinal.trabajoFinal.models.Cliente;
import com.trabajoFinal.trabajoFinal.services.Interface.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ClienteControllers {

    @Autowired
    private IClienteService service;

    @GetMapping("/api/clientes")
    public List<Cliente> getAll(){
        return service.getAll();
    }

    @PostMapping("/api/clientes")
    public void save(@RequestBody Cliente cliente) {
        service.save(cliente);
    }

    @GetMapping("/api/clientes/buscar")
    public int buscarCliente(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String email) {
        return service.buscarCliente(nombre, apellido, email);
    }
}
