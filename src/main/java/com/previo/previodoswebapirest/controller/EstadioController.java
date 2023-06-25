package com.previo.previodoswebapirest.controller;

import com.previo.previodoswebapirest.entities.Estadio;
import com.previo.previodoswebapirest.repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estadio")
public class EstadioController {

    @Autowired
    EstadioRepository estadioRepository;

    @DeleteMapping("/{id}")
    public void eliminarEstadio(@PathVariable Integer id){
        Estadio estadio = estadioRepository.findById(id).get();
        estadioRepository.delete(estadio);
    }

}
