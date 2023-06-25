package com.previo.previodoswebapirest.model.dto;

import lombok.Data;

@Data
public class ResultadoDTO {
    private String nombre;
    private int goles;
    private int amarillas;
    private int rojas;
}
