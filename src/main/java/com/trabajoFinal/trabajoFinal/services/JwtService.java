package com.trabajoFinal.trabajoFinal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trabajoFinal.trabajoFinal.models.Cliente;
import com.trabajoFinal.trabajoFinal.models.Persona;
import com.trabajoFinal.trabajoFinal.models.Proveedor;
import com.trabajoFinal.trabajoFinal.services.Interface.IClienteService;
import com.trabajoFinal.trabajoFinal.services.Interface.IJwtService;
import com.trabajoFinal.trabajoFinal.services.Interface.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtService implements IJwtService {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IProveedorService proveedorService;

    @Override
    public Persona convertirTextoPersona(String texto) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(texto, Persona.class);

        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public Persona asignarTipo(Persona persona) {

        // Obtener todas las personas (clientes y proveedores)
        List<Cliente> clientes = clienteService.getAll();
        List<Proveedor> proveedores = proveedorService.getAll();

        // Iterar sobre la lista de clientes
        for (Cliente cliente : clientes) {
            // Verificar si los atributos coinciden
            if (sonIguales(cliente, persona)) {
                persona.setTipo("cliente");
                return persona;
            }
        }

        // Iterar sobre la lista de proveedores
        for (Proveedor proveedor : proveedores) {

            // Verificar si los atributos coinciden
            if (sonIguales(proveedor, persona)) {
                persona.setTipo("proveedor");
                return persona;
            }
        }

        // Si no se encontró ninguna coincidencia, retornar null
        return null;
    }

    // Método para verificar si los atributos de una persona coinciden con los de un cliente o proveedor
    private boolean sonIguales(Cliente cliente, Persona persona) {
        return cliente.getUsuario().getNombre().equals(persona.getNombre()) &&
                cliente.getUsuario().getApellido().equals(persona.getApellido()) &&
                cliente.getUsuario().getEmail().equals(persona.getEmail());
    }

    private boolean sonIguales(Proveedor proveedor, Persona persona) {
        return proveedor.getUsuario().getNombre().equals(persona.getNombre()) &&
                proveedor.getUsuario().getApellido().equals(persona.getApellido()) &&
                proveedor.getUsuario().getEmail().equals(persona.getEmail());
    }

}
