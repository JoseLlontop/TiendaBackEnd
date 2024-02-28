package com.trabajoFinal.trabajoFinal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trabajoFinal.trabajoFinal.models.Cliente;
import com.trabajoFinal.trabajoFinal.models.Persona;
import com.trabajoFinal.trabajoFinal.models.Proveedor;
import com.trabajoFinal.trabajoFinal.services.Interface.IClienteService;
import com.trabajoFinal.trabajoFinal.services.Interface.IJwtService;
import com.trabajoFinal.trabajoFinal.services.Interface.IProveedorService;
import io.jsonwebtoken.Claims;
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
    public Persona convertirJsonAPersona(Claims usuario) {

        Persona persona = new Persona();
        persona.setNombre(usuario.get("Nombre", String.class));
        persona.setRol(usuario.get("Rol", String.class));
        persona.setApellido(usuario.get("Apellido", String.class));
        persona.setEmail(usuario.get("Email", String.class));
        persona.setCuil(usuario.get("Cuil", String.class));
        persona.setEstado(parseBoolean(usuario.get("Estado", String.class)));
        persona.setEstadoCrediticio(parseBoolean(usuario.get("EstadoCrediticio", String.class)));

        return persona;
    }

    @Override
    public Persona asignarTipo(Persona persona, String tipoIngresoSistema) {

        System.out.println("tipoIngresoSistema = " + tipoIngresoSistema);

        // Obtener todas las personas (clientes y proveedores)
        List<Cliente> clientes = clienteService.getAll();
        List<Proveedor> proveedores = proveedorService.getAll();

        if (tipoIngresoSistema.equalsIgnoreCase("proveedor")) {

            // Iterar sobre la lista de proveedores
            for (Proveedor proveedor : proveedores) {

                // Verificar si los atributos coinciden
                if (sonIguales(proveedor, persona)) {
                    persona.setTipo("proveedor");
                    return persona;
                }
            }
        }

        if (tipoIngresoSistema.equalsIgnoreCase("cliente")) {

            // Iterar sobre la lista de clientes
            for (Cliente cliente : clientes) {
                // Verificar si los atributos coinciden
                if (sonIguales(cliente, persona)) {
                    persona.setTipo("cliente");
                    return persona;
                }
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

    private boolean parseBoolean(String value) {
        // Verificar si el valor es "true" (ignorando mayúsculas y minúsculas)
        if ("true".equalsIgnoreCase(value)) {
            return true;
        }
        // Verificar si el valor es "false" (ignorando mayúsculas y minúsculas)
        else if ("false".equalsIgnoreCase(value)) {
            return false;

        } else {
            throw new IllegalArgumentException("El valor no es válido para convertir a booleano: " + value);
        }
    }

}
