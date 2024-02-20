package com.agendamento.api.controller;


import com.agendamento.api.model.Agendamento;
import com.agendamento.api.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @PostMapping
    public Agendamento salvar(@RequestBody Agendamento agendamento){
        return agendamentoRepository.save(agendamento);
    }

    @GetMapping
    public List<Agendamento>listarTudo(){
        return agendamentoRepository.findAll();
    }

}
