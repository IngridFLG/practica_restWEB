package com.previo.previodoswebapirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seleccion")
public class Seleccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String grupo;

    @ManyToOne
    @JoinColumn(name = "continente_id")
    private Continente continente;

    @OneToMany(mappedBy = "seleccion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Resultado> resultados;

}
