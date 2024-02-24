package com.trabajoFinal.trabajoFinal.services;

import com.trabajoFinal.trabajoFinal.models.Cliente;
import com.trabajoFinal.trabajoFinal.models.Persona;
import com.trabajoFinal.trabajoFinal.models.Proveedor;
import com.trabajoFinal.trabajoFinal.models.Usuario;
import com.trabajoFinal.trabajoFinal.repository.ClienteRepository;
import com.trabajoFinal.trabajoFinal.services.Interface.IClienteService;
import com.trabajoFinal.trabajoFinal.services.Interface.IProveedorService;
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

    @Override
    public int buscarCliente(String nombre, String apellido, String email) {

        // Obtener todas las personas (clientes y proveedores)
        List<Cliente> clientes = (List<Cliente>) repository.findAll();

        // Iterar sobre la lista de clientes
        for (Cliente cliente : clientes) {
            // Verificar si los atributos coinciden
            if (sonIguales(cliente, nombre, apellido, email)) {

                return cliente.getUsuario_ID();
            }
        }

        // Si no se encontró ninguna coincidencia
        return 0;
    }

    private boolean sonIguales(Cliente cliente, String nombre, String apellido, String email) {
        return cliente.getUsuario().getNombre().equals(nombre) &&
                cliente.getUsuario().getApellido().equals(apellido) &&
                cliente.getUsuario().getEmail().equals(email);
    }
}
