package com.trabajoFinal.trabajoFinal.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @Column(name = "usuario_ID")
    private int usuario_ID;

    // Permite que la clave primaria de la entidad Usuario también sea la clave primaria de la entidad actual
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Usuario usuario;
}
