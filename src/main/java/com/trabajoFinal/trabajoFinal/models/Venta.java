package com.trabajoFinal.trabajoFinal.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "monto_total")
    private float monto_total;

    @Column(name = "direccion_entrega")
    private String direccion_entrega;

    @ManyToOne
    @JoinColumn(name = "cliente_ID")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_ID")
    private Producto producto;
}
