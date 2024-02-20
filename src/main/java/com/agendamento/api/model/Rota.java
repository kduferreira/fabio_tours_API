package com.agendamento.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rota;

    private String destino;
    private LocalDateTime data;

    
    @OneToMany
    @JoinColumn(name = "id_rota")
    private List<Agendamento> agendados;


}
