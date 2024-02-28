package com.trabajoFinal.trabajoFinal.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Persona {

    //Datos que retorna el Renaper
    private String nombre;
    private String rol;
    private String apellido;
    private String email;
    private String cuil;
    private boolean estado;
    private boolean estadoCrediticio;
    //Dato que provee mi sistema
    private String tipo;

}
