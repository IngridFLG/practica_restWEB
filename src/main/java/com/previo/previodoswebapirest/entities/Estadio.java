package com.previo.previodoswebapirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "estadio")
public class Estadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private Integer capacidad;

    @OneToMany(mappedBy = "estadio", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Partido> partidos;


}
