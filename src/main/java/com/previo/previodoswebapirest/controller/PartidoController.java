package com.previo.previodoswebapirest.controller;

import com.previo.previodoswebapirest.entities.Partido;
import com.previo.previodoswebapirest.entities.Resultado;
import com.previo.previodoswebapirest.entities.Seleccion;
import com.previo.previodoswebapirest.model.dto.ResultadoDTO;
import com.previo.previodoswebapirest.repository.PartidoRepository;
import com.previo.previodoswebapirest.repository.ResultadoRepository;
import com.previo.previodoswebapirest.repository.SeleccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    PartidoRepository partidoRepository;

    @Autowired
    SeleccionRepository seleccionRepository;

    @Autowired
    ResultadoRepository resultadoRepository;

    @GetMapping
    public List<Partido> listaPartidos(){
        List<Partido> partidos = partidoRepository.findAll();
        return partidos;
    }

    @GetMapping("/{partidoId}/resultados")
    public List<ResultadoDTO> listaPartidosResultado(@PathVariable Integer partidoId){
        List<Resultado> resultados = resultadoRepository.findByPartidoId(partidoId);
        List<ResultadoDTO> resultadosDTO = new ArrayList<>();
        for (Resultado resultado : resultados) {
            ResultadoDTO resultadoDTO = new ResultadoDTO();

            Seleccion seleccion = seleccionRepository.findById(resultado.getSeleccion().getId()).orElse(null);
            if (seleccion != null) {
                resultadoDTO.setNombre(seleccion.getNombre());
                resultadoDTO.setGoles(resultado.getGoles());
                resultadoDTO.setAmarillas(resultado.getAmarillas());
                resultadoDTO.setRojas(resultado.getRojas());

                resultadosDTO.add(resultadoDTO);
            }
        }

        return resultadosDTO;

    }




}
