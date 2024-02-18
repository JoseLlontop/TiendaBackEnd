package com.trabajoFinal.trabajoFinal.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Persona {

    private String nombre;
    private String apellido;
    private String email;
    private String estadoCrediticio;
    private boolean vivo;

    private String tipo;

}
