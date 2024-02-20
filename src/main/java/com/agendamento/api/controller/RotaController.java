package com.agendamento.api.controller;

import com.agendamento.api.model.Rota;
import com.agendamento.api.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rotas")
public class RotaController {
    @Autowired
    private RotaRepository rotaRepository;

    @PostMapping
    public Rota salvar(@RequestBody Rota rota){
        return rotaRepository.save(rota);
    }


    @GetMapping
    public List<Rota> buscarTudo(){
        return rotaRepository.findAll();
    }
}
