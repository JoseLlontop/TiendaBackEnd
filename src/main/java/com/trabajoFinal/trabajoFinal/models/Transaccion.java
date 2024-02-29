package com.trabajoFinal.trabajoFinal.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Transaccion {

    private String origin_cbu;
    private double amount;
    private String destination_cbu;
    private String motive;
    private Integer number;
    private long origin_cuil;
    private long destination_cuil;
}
