package com.previo.previodoswebapirest.controller;

import com.previo.previodoswebapirest.entities.Partido;
import com.previo.previodoswebapirest.entities.Resultado;
import com.previo.previodoswebapirest.entities.Seleccion;
import com.previo.previodoswebapirest.repository.PartidoRepository;
import com.previo.previodoswebapirest.repository.ResultadoRepository;
import com.previo.previodoswebapirest.repository.SeleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired
    ResultadoRepository resultadoRepository;

    @Autowired
    PartidoRepository partidoRepository;

    @Autowired
    SeleccionRepository seleccionRepository;

    @PutMapping("/{id}")
    public void actualizarResultados(@PathVariable Integer id, @RequestBody Resultado resultadonuevo){
        Resultado resultado = resultadoRepository.findById(id).get();

        resultado.setGoles(resultadonuevo.getGoles());
        resultado.setAmarillas(resultadonuevo.getAmarillas());
        resultado.setRojas(resultadonuevo.getRojas());

        Seleccion seleccion = seleccionRepository.findById(resultadonuevo.getSeleccion().getId()).orElse(null);
        resultado.setSeleccion(seleccion);

        // Actualizar la relación con el partido
        Partido partido = partidoRepository.findById(resultadonuevo.getPartido().getId()).orElse(null);
        resultado.setPartido(partido);

        // Guardar el resultado actualizado en la base de datos
        resultadoRepository.save(resultado);

    }

    @PostMapping
    public void guardarResultados(@RequestBody Resultado resultado){
        resultadoRepository.save(resultado);
    }
}
