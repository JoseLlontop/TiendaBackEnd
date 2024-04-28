package com.trabajoFinal.trabajoFinal.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity //Referencia a que es una entidad de la BD
@Table(name= "producto") //Tabla a la que tiene que ir
public class Producto {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private float precio;

    @Column(name = "imagen")
    private String imagen;

    //Propiedad auxiliar solo para almacenar momentáneamente la url de la imagen
    //para luego guardarla en la columna de la tabla imagen
    //@Transient
    //private String imagenURL;

}
