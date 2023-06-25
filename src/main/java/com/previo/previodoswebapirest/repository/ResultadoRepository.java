package com.previo.previodoswebapirest.repository;

import com.previo.previodoswebapirest.entities.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {
    List<Resultado> findByPartidoId(int partidoId);

    Resultado findById(int id);
}
