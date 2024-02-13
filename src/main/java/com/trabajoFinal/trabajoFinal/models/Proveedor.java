package com.trabajoFinal.trabajoFinal.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @Column(name = "ID")
    private Long ID;

    // Permite que la clave primaria de la entidad Usuario también sea la clave primaria de la entidad actual
    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
}
