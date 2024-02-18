package com.trabajoFinal.trabajoFinal.services.Interface;

import com.trabajoFinal.trabajoFinal.models.Persona;

public interface IJwtService {

    Persona convertirTextoPersona(String texto);

    Persona asignarTipo(Persona persona);
}
