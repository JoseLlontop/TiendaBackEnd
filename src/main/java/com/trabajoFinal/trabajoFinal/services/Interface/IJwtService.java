package com.trabajoFinal.trabajoFinal.services.Interface;

import com.trabajoFinal.trabajoFinal.models.Persona;
import io.jsonwebtoken.Claims;

public interface IJwtService {

    Persona convertirJsonAPersona(Claims texto);

    Persona asignarTipo(Persona persona, String tipoIngresoSistema);
}
