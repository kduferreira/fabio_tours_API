package com.agendamento.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id_client;
    private String name;
    private String endereco;
    private String cidade;
    private String telefone;
    private String cpf;
    //opcional
    private String rg;


    @OneToMany
    @JoinColumn(name = "id_client")
    private List<Agendamento> agendados;

}
