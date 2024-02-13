package com.trabajoFinal.trabajoFinal.models;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Setter @Getter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;


}
