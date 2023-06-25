package com.previo.previodoswebapirest.controller;

import com.previo.previodoswebapirest.entities.Continente;
import com.previo.previodoswebapirest.entities.Seleccion;
import com.previo.previodoswebapirest.repository.ContinenteRepository;
import com.previo.previodoswebapirest.repository.SeleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/selecciones")
public class SeleccionController {

    @Autowired
    SeleccionRepository seleccionRepository;

    @Autowired
    ContinenteRepository continenteRepository;

    @GetMapping
    public List<Seleccion> listarSelecciones(){
        List<Seleccion> seleccion = seleccionRepository.findAll();
        return seleccion;
    }

    @PostMapping
    public void guardarSelecciones(@RequestBody Seleccion seleccion){
        Continente continente = continenteRepository.findById(seleccion.getContinente().getId())
                .orElseThrow(() -> new RuntimeException("Continente no encontrado"));

        seleccion.setContinente(continente);
        seleccionRepository.save(seleccion);
    }

    @GetMapping("/grupo/{grupo}")
    public List<Seleccion> listarSeleccionesPorGrupo(@PathVariable String grupo){
        List<Seleccion> seleccion = seleccionRepository.findByGrupo(grupo);
        return seleccion;
    }



}
