package com.trabajoFinal.trabajoFinal.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "ID")
    private Long ID;

    // Permite que la clave primaria de la entidad Usuario también sea la clave primaria de la entidad actual
    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
}
