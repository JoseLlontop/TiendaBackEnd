package com.trabajoFinal.trabajoFinal.controllers;

import com.trabajoFinal.trabajoFinal.models.Proveedor;
import com.trabajoFinal.trabajoFinal.services.Interface.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ProveedorControllers {

    @Autowired
    private IProveedorService service;

    @GetMapping("/api/proveedores")
    public List<Proveedor> getAll(){
        return service.getAll();
    }

    @PostMapping("/api/proveedores")
    public void save(@RequestBody Proveedor proveedor){
        service.save(proveedor);
    }

}
