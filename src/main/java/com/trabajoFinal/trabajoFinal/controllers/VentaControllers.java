package com.trabajoFinal.trabajoFinal.controllers;

import com.trabajoFinal.trabajoFinal.models.Venta;
import com.trabajoFinal.trabajoFinal.services.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class VentaControllers {

    @Autowired
    private IVentaService service;

    @PostMapping("/api/ventas")
    public void save(@RequestBody Venta venta){
        service.save(venta);
    }

}
