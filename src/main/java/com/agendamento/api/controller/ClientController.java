package com.agendamento.api.controller;

import com.agendamento.api.model.Client;
import com.agendamento.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    public Client salvar( @RequestBody Client client){
    return clientRepository.save(client);
    }


    @GetMapping
    public List<Client> buscarTudo( ){
        return clientRepository.findAll();
    }



}
