package com.previo.previodoswebapirest.repository;

import com.previo.previodoswebapirest.entities.Seleccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {
    List<Seleccion> findByGrupo(String grupo);
}
