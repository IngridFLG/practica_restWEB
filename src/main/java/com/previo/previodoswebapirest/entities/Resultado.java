package com.previo.previodoswebapirest.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "resultado")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer goles;

    private Integer amarillas;

    private Integer rojas;

    @ManyToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "seleccion_id")
    private Seleccion seleccion;
}
